package com.safety.service;

import com.safety.model.*;
import com.safety.repository.InspectionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;

@Service
public class DailyInspectionService {

    private final InspectionRepository inspectionRepository;
    private final AlertLogService alertLogService; // 다른 조원이 만든 로그 서비스가 있다면 패키지 확인 필요

    public DailyInspectionService(InspectionRepository inspectionRepository, AlertLogService alertLogService) {
        this.inspectionRepository = inspectionRepository;
        this.alertLogService = alertLogService;
    }

    @Transactional
    public DailyInspectionResponseDto registerInspection(DailyInspectionRegisterDto dto) {
        if (dto.getItems() == null || dto.getItems().isEmpty()) {
            throw new IllegalArgumentException("점검 상세 내역 리스트(items)가 아예 비어있을 경우 등록할 수 없습니다.");
        }
        if (dto.getSubmittedBy() == null || dto.getSubmittedBy().trim().isEmpty()) {
            throw new IllegalArgumentException("제출자는 공백일 수 없습니다.");
        }

        DailyInspection dailyInspection = new DailyInspection();
        dailyInspection.setLabId(dto.getLabId());
        dailyInspection.setDate(dto.getDate());
        dailyInspection.setSubmittedBy(dto.getSubmittedBy());
        dailyInspection.setStatus(dto.getStatus());

        for (InspectionItemDto itemDto : dto.getItems()) {
            InspectionItem item = new InspectionItem();
            item.setCheckItem(itemDto.getCheckItem());
            item.setResult(itemDto.getResult());
            dailyInspection.addItem(item);
        }

        DailyInspection saved = inspectionRepository.save(dailyInspection);

        // 요구사항: 성공 시 alertLogService 호출
        alertLogService.createLog("신규 일상점검 등록 완료", "INSPECTION");

        return new DailyInspectionResponseDto(
                saved.getId(),
                saved.getLabId(),
                saved.getDate(),
                saved.getSubmittedBy(),
                saved.getStatus(),
                saved.getItems().stream().map(i -> {
                    InspectionItemDto idto = new InspectionItemDto();
                    idto.setCheckItem(i.getCheckItem());
                    idto.setResult(i.getResult());
                    return idto;
                }).collect(Collectors.toList())
        );
    }
}