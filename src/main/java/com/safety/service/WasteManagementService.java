package com.safety.service;

import com.safety.model.WasteInfo;
import com.safety.model.WasteInfoRegisterDto;
import com.safety.model.WasteInfoResponseDto;
import com.safety.model.WasteType;
import com.safety.repository.WasteRepository;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class WasteManagementService {

    private static final String WASTE_LOG_MESSAGE = "신규 폐기물 정보 등록 완료";
    private static final String WASTE_SUB_SYSTEM = "WASTE";

    private final WasteRepository wasteRepository;
    private final AlertLogService alertLogService;
    private final AtomicLong sequence = new AtomicLong(1);

    public WasteManagementService(WasteRepository wasteRepository, AlertLogService alertLogService) {
        this.wasteRepository = wasteRepository;
        this.alertLogService = alertLogService;
    }

    public WasteInfoResponseDto registerWasteInfo(WasteInfoRegisterDto request) {
        validateRequest(request);

        WasteType wasteType = WasteType.findByTypeId(request.getTypeId())
            .orElseThrow(() -> new IllegalArgumentException("Unknown waste typeId"));

        WasteInfo wasteInfo = new WasteInfo(
            nextWasteId(),
            wasteType.getTypeId(),
            wasteType.getTypeName(),
            request.getLabId(),
            request.getQuantity(),
            request.getUnit(),
            request.getGeneratedDate()
        );

        WasteInfo savedWasteInfo = wasteRepository.save(wasteInfo);
        alertLogService.createLog(WASTE_LOG_MESSAGE, WASTE_SUB_SYSTEM);

        return WasteInfoResponseDto.from(savedWasteInfo);
    }

    private void validateRequest(WasteInfoRegisterDto request) {
        if (request.getTypeId() == null || request.getTypeId().isBlank()) {
            throw new IllegalArgumentException("typeId is required");
        }
        if (request.getLabId() == null || request.getLabId().isBlank()) {
            throw new IllegalArgumentException("labId is required");
        }
        if (request.getQuantity() == null || request.getQuantity() <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        if (request.getUnit() == null || request.getUnit().isBlank()) {
            throw new IllegalArgumentException("unit is required");
        }
        if (request.getGeneratedDate() == null) {
            throw new IllegalArgumentException("generatedDate is required");
        }
        if (request.getGeneratedDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("generatedDate cannot be future date");
        }
    }

    private String nextWasteId() {
        return "WASTE" + String.format("%03d", sequence.getAndIncrement());
    }
}
