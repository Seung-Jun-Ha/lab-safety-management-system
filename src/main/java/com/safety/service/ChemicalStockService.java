package com.safety.service;

import com.safety.model.ChemicalProduct;
import com.safety.model.ReagentStock;
import com.safety.model.ReagentStockRegisterDto;
import com.safety.model.ReagentStockResponseDto;
import com.safety.repository.ChemicalRepository;
import org.springframework.stereotype.Service;

@Service
public class ChemicalStockService {

    private final ChemicalRepository chemicalRepository;
    private final AlertLogService alertLogService;

    public ChemicalStockService(ChemicalRepository chemicalRepository, AlertLogService alertLogService) {
        this.chemicalRepository = chemicalRepository;
        this.alertLogService = alertLogService;
    }

    public ReagentStockResponseDto registerChemicalStock(ReagentStockRegisterDto request) {
        validateQuantity(request);

        ReagentStock reagentStock = new ReagentStock();
        reagentStock.setLabId(request.getLabId());
        reagentStock.setProductId(request.getProductId());
        reagentStock.setQuantity(request.getQuantity());
        reagentStock.setUnit(request.getUnit());
        reagentStock.setLocation(request.getLocation());

        ReagentStock savedStock = chemicalRepository.save(reagentStock);
        alertLogService.createLog("신규 시약 재고 등록 완료", "CHEMICAL");

        return toResponseDto(savedStock);
    }

    private void validateQuantity(ReagentStockRegisterDto request) {
        if (request == null) {
            throw new IllegalArgumentException("등록 요청 데이터는 필수입니다.");
        }

        if (request.getQuantity() == null || request.getQuantity() <= 0) {
            throw new IllegalArgumentException("등록 수량은 0보다 커야 합니다.");
        }
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
