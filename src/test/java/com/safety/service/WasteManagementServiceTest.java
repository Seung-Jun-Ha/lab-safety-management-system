package com.safety.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.safety.model.WasteInfoRegisterDto;
import com.safety.model.WasteInfoResponseDto;
import com.safety.model.WasteSearchCriteria;
import com.safety.repository.FakeWasteRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WasteManagementServiceTest {

    private FakeWasteRepository wasteRepository;
    private AlertLogService alertLogService;
    private WasteManagementService wasteManagementService;
    private WasteQueryService wasteQueryService;

    @BeforeEach
    void setUp() {
        wasteRepository = new FakeWasteRepository();
        alertLogService = new AlertLogService();
        wasteManagementService = new WasteManagementService(wasteRepository, alertLogService);
        wasteQueryService = new WasteQueryService(wasteRepository);
    }

    @Test
    @DisplayName("TC-01 신규 연구실 폐기물 정보 등록 성공")
    void registerWasteInfoSucceeds() {
        WasteInfoRegisterDto request = new WasteInfoRegisterDto("W01", "LAB001", 12.5, "kg", LocalDate.now());

        WasteInfoResponseDto response = wasteManagementService.registerWasteInfo(request);

        assertThat(response.getWasteId()).isNotBlank();
        assertThat(response.getTypeId()).isEqualTo("W01");
        assertThat(response.getTypeName()).isEqualTo("일반 폐기물");
        assertThat(response.getLabId()).isEqualTo("LAB001");
        assertThat(alertLogService.findAll()).hasSize(1);
        assertThat(alertLogService.findAll().get(0).getMessage()).isEqualTo("신규 폐기물 정보 등록 완료");
        assertThat(alertLogService.findAll().get(0).getSubSystem()).isEqualTo("WASTE");
    }

    @Test
    @DisplayName("TC-02 연구실별 폐기물 배출 이력 조회 성공")
    void searchWasteInfoByLabAndTypeSucceeds() {
        wasteManagementService.registerWasteInfo(new WasteInfoRegisterDto("W01", "LAB001", 12.5, "kg", LocalDate.now()));
        wasteManagementService.registerWasteInfo(new WasteInfoRegisterDto("W02", "LAB002", 3.0, "L", LocalDate.now()));

        var result = wasteQueryService.searchWasteInfo(new WasteSearchCriteria("LAB001", "W01"));

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getLabId()).isEqualTo("LAB001");
        assertThat(result.get(0).getTypeId()).isEqualTo("W01");
    }

    @Test
    @DisplayName("추가 조회 검증: 일치 조건이 없으면 빈 리스트 반환")
    void searchWasteInfoReturnsEmptyListWhenNoCriteriaMatches() {
        wasteManagementService.registerWasteInfo(new WasteInfoRegisterDto("W01", "LAB001", 12.5, "kg", LocalDate.now()));

        var result = wasteQueryService.searchWasteInfo(new WasteSearchCriteria("LAB404", "W01"));

        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("TC-03 미래 날짜로 폐기물 발생 등록 요청 시 실패")
    void registerWasteInfoFailsWhenGeneratedDateIsFuture() {
        WasteInfoRegisterDto request = new WasteInfoRegisterDto("W01", "LAB001", 10.0, "kg", LocalDate.now().plusDays(5));

        assertThatThrownBy(() -> wasteManagementService.registerWasteInfo(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("future");
    }

    @Test
    @DisplayName("추가 등록 검증: 알 수 없는 폐기물 타입 ID 등록 요청 시 실패")
    void registerWasteInfoFailsWhenTypeIdIsUnknown() {
        WasteInfoRegisterDto request = new WasteInfoRegisterDto("INVALID", "LAB001", 10.0, "kg", LocalDate.now());

        assertThatThrownBy(() -> wasteManagementService.registerWasteInfo(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Unknown waste typeId");
    }
}
