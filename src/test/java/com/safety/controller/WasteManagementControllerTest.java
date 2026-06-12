package com.safety.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safety.model.WasteInfoRegisterDto;
import com.safety.model.WasteInfoResponseDto;
import com.safety.service.WasteManagementService;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(WasteManagementController.class)
@Import(ApiExceptionHandler.class)
class WasteManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private WasteManagementService wasteManagementService;

    @Test
    @DisplayName("TC-01 API 신규 연구실 폐기물 정보 등록 성공")
    void registerWasteInfoApiSucceeds() throws Exception {
        WasteInfoRegisterDto request = new WasteInfoRegisterDto("W01", "LAB001", 12.5, "kg", LocalDate.now());
        WasteInfoResponseDto response = new WasteInfoResponseDto(
            "WASTE001",
            "W01",
            "일반 폐기물",
            "LAB001",
            12.5,
            "kg",
            LocalDate.now()
        );
        when(wasteManagementService.registerWasteInfo(any(WasteInfoRegisterDto.class))).thenReturn(response);

        mockMvc.perform(post("/api/waste/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.wasteId").value("WASTE001"))
            .andExpect(jsonPath("$.typeName").value("일반 폐기물"));
    }

    @Test
    @DisplayName("TC-03 API 미래 날짜로 폐기물 발생 등록 요청 시 실패")
    void registerWasteInfoApiFailsWhenGeneratedDateIsFuture() throws Exception {
        WasteInfoRegisterDto request = new WasteInfoRegisterDto("W01", "LAB001", 10.0, "kg", LocalDate.now().plusDays(5));

        mockMvc.perform(post("/api/waste/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("TC-04 필수 식별자인 폐기물 처리 타입 ID 누락 시 실패")
    void registerWasteInfoFailsWhenTypeIdIsBlank() throws Exception {
        WasteInfoRegisterDto request = new WasteInfoRegisterDto("", "LAB001", 5.0, "kg", LocalDate.now());

        mockMvc.perform(post("/api/waste/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("API 비즈니스 예외 발생 시 400 Bad Request 반환")
    void registerWasteInfoReturnsBadRequestWhenServiceRejectsRequest() throws Exception {
        WasteInfoRegisterDto request = new WasteInfoRegisterDto("INVALID", "LAB001", 5.0, "kg", LocalDate.now());
        when(wasteManagementService.registerWasteInfo(any(WasteInfoRegisterDto.class)))
            .thenThrow(new IllegalArgumentException("Unknown waste typeId"));

        mockMvc.perform(post("/api/waste/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("Unknown waste typeId"));
    }
}
