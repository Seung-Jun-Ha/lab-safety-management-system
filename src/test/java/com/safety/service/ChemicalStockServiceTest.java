package com.safety.service;

import com.safety.model.ChemicalProduct;
import com.safety.model.ReagentStock;
import com.safety.model.ReagentStockRegisterDto;
import com.safety.model.ReagentStockResponseDto;
import com.safety.repository.ChemicalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ChemicalStockServiceTest {

    @Mock
    private ChemicalRepository chemicalRepository;

    @Mock
    private AlertLogService alertLogService;

    @InjectMocks
    private ChemicalStockService chemicalStockService;

    @Test
    void registerChemicalStockSucceeds() {
        ReagentStockRegisterDto request = new ReagentStockRegisterDto(
                "LAB001",
                "CHEM102",
                5.0,
                "L",
                "시약장 A-1"
        );

        when(chemicalRepository.save(any(ReagentStock.class))).thenAnswer(invocation -> {
            ReagentStock stock = invocation.getArgument(0);
            stock.setStockId("STOCK-001");
            stock.setRegisteredAt(LocalDateTime.of(2026, 6, 3, 10, 0));
            return stock;
        });
        when(chemicalRepository.findProductById("CHEM102"))
                .thenReturn(Optional.of(new ChemicalProduct("CHEM102", "염산", "7647-01-0", "CORROSIVE")));

        ReagentStockResponseDto response = chemicalStockService.registerChemicalStock(request);

        assertThat(response.getStockId()).isEqualTo("STOCK-001");
        assertThat(response.getLabId()).isEqualTo("LAB001");
        assertThat(response.getProductId()).isEqualTo("CHEM102");
        assertThat(response.getProductName()).isEqualTo("염산");
        assertThat(response.getQuantity()).isEqualTo(5.0);
        assertThat(response.getUnit()).isEqualTo("L");
        assertThat(response.getLocation()).isEqualTo("시약장 A-1");

        verify(chemicalRepository).save(any(ReagentStock.class));
        verify(alertLogService).createLog("신규 시약 재고 등록 완료", "CHEMICAL");
    }

    @Test
    void registerChemicalStockRejectsNegativeQuantity() {
        ReagentStockRegisterDto request = new ReagentStockRegisterDto(
                "LAB001",
                "CHEM102",
                -2.5,
                "L",
                "시약장 A-1"
        );

        assertThatThrownBy(() -> chemicalStockService.registerChemicalStock(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("등록 수량은 0보다 커야 합니다.");

        verify(chemicalRepository, never()).save(any(ReagentStock.class));
        verify(alertLogService, never()).createLog(any(), any());
    }
}
