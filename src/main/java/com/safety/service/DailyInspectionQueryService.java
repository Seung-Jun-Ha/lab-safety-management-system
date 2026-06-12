package com.safety.service;

import com.safety.model.DailyInspection;
import com.safety.model.DailyInspectionSummaryDto;
import com.safety.model.InspectionSearchCriteria;
import com.safety.repository.InspectionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class DailyInspectionQueryService {

    private final InspectionRepository inspectionRepository;

    public DailyInspectionQueryService(InspectionRepository inspectionRepository) {
        this.inspectionRepository = inspectionRepository;
    }

    public List<DailyInspectionSummaryDto> searchSummary(InspectionSearchCriteria criteria) {
        List<DailyInspection> inspections = inspectionRepository.findByLabIdAndStatus(
                criteria.getLabId(),
                criteria.getStatus()
        );

        return inspections.stream()
                .map(ins -> new DailyInspectionSummaryDto(
                        ins.getId(),
                        ins.getLabId(),
                        ins.getDate(),
                        ins.getSubmittedBy(),
                        ins.getStatus(),
                        ins.getItems().size()
                ))
                .collect(Collectors.toList());
    }
}