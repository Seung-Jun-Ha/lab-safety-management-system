package com.safety.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.safety.model.WasteInfoResponseDto;
import com.safety.service.WasteQueryService;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(WasteQueryController.class)
class WasteQueryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WasteQueryService wasteQueryService;

    @Test
    @DisplayName("TC-02 API 연구실별 폐기물 배출 이력 조회 성공")
    void searchWasteInfoApiSucceeds() throws Exception {
        when(wasteQueryService.searchWasteInfo(any())).thenReturn(List.of(
            new WasteInfoResponseDto("WASTE001", "W01", "일반 폐기물", "LAB001", 12.5, "kg", LocalDate.now())
        ));

        mockMvc.perform(get("/api/waste/search")
                .param("labId", "LAB001")
                .param("typeId", "W01"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].wasteId").value("WASTE001"))
            .andExpect(jsonPath("$[0].labId").value("LAB001"))
            .andExpect(jsonPath("$[0].typeId").value("W01"));
    }
}
