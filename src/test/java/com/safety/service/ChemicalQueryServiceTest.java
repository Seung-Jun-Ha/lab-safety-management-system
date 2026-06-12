package com.safety.service;

import com.safety.model.ChemicalProduct;
import com.safety.model.ChemicalSearchCriteria;
import com.safety.model.ReagentStock;
import com.safety.model.ReagentStockResponseDto;
import com.safety.repository.ChemicalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ChemicalQueryServiceTest {

    @Mock
    private ChemicalRepository chemicalRepository;

    @InjectMocks
    private ChemicalQueryService chemicalQueryService;

    @Test
    void searchChemicalStocksByLabIdSucceeds() {
        ChemicalSearchCriteria criteria = new ChemicalSearchCriteria("LAB001", null);
        ReagentStock stock = new ReagentStock(
                "STOCK-001",
                "LAB001",
                "CHEM102",
                5.0,
                "L",
                "시약장 A-1",
                LocalDateTime.of(2026, 6, 3, 10, 0)
        );

        when(chemicalRepository.findByCriteria(criteria)).thenReturn(List.of(stock));
        when(chemicalRepository.findProductById("CHEM102"))
                .thenReturn(Optional.of(new ChemicalProduct("CHEM102", "염산", "7647-01-0", "CORROSIVE")));

        List<ReagentStockResponseDto> result = chemicalQueryService.searchChemicalStocks(criteria);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStockId()).isEqualTo("STOCK-001");
        assertThat(result.get(0).getLabId()).isEqualTo("LAB001");
        assertThat(result.get(0).getProductName()).isEqualTo("염산");
    }

    @Test
    void searchChemicalStocksWithInvalidLabIdReturnsEmptyList() {
        ChemicalSearchCriteria criteria = new ChemicalSearchCriteria("INVALID_ID", null);

        when(chemicalRepository.findByCriteria(criteria)).thenReturn(List.of());

        List<ReagentStockResponseDto> result = chemicalQueryService.searchChemicalStocks(criteria);

        assertThat(result).isEmpty();
    }
}
