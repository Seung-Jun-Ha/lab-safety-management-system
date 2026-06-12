package com.safety.service;

import com.safety.model.ChemicalProduct;
import com.safety.model.ChemicalSearchCriteria;
import com.safety.model.ReagentStock;
import com.safety.model.ReagentStockResponseDto;
import com.safety.repository.ChemicalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChemicalQueryService {

    private final ChemicalRepository chemicalRepository;

    public ChemicalQueryService(ChemicalRepository chemicalRepository) {
        this.chemicalRepository = chemicalRepository;
    }

    public List<ReagentStockResponseDto> searchChemicalStocks(ChemicalSearchCriteria criteria) {
        return chemicalRepository.findByCriteria(criteria).stream()
                .map(this::toResponseDto)
                .toList();
    }

    private ReagentStockResponseDto toResponseDto(ReagentStock stock) {
        String productName = chemicalRepository.findProductById(stock.getProductId())
                .map(ChemicalProduct::getProductName)
                .orElse(null);

        return new ReagentStockResponseDto(
                stock.getStockId(),
                stock.getLabId(),
                stock.getProductId(),
                productName,
                stock.getQuantity(),
                stock.getUnit(),
                stock.getLocation(),
                stock.getRegisteredAt()
        );
    }
}
