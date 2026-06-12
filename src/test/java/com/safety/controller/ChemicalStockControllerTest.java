package com.safety.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safety.model.ReagentStockRegisterDto;
import com.safety.service.ChemicalStockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChemicalStockController.class)
class ChemicalStockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ChemicalStockService chemicalStockService;

    @Test
    void registerChemicalStockWithNegativeQuantityReturnsBadRequest() throws Exception {
        ReagentStockRegisterDto request = new ReagentStockRegisterDto(
                "LAB001",
                "CHEM102",
                -2.5,
                "L",
                "시약장 A-1"
        );

        when(chemicalStockService.registerChemicalStock(any(ReagentStockRegisterDto.class)))
                .thenThrow(new IllegalArgumentException("등록 수량은 0보다 커야 합니다."));

        mockMvc.perform(post("/api/chemical/stock/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("등록 수량은 0보다 커야 합니다."));
    }
}
