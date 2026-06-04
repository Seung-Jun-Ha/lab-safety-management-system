package com.safety.service;

import java.util.List;

import com.safety.model.Lab;
import com.safety.model.LabResponseDto;
import com.safety.model.LabSearchCriteria;
import com.safety.repository.LabRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LabQueryService {

    private final LabRepository labRepository;

    public LabQueryService(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

    public List<LabResponseDto> searchLabs(LabSearchCriteria criteria) {
        return labRepository.findAll().stream()
                .filter(lab -> matches(criteria, lab))
                .map(this::toResponse)
                .toList();
    }

    private boolean matches(LabSearchCriteria criteria, Lab lab) {
        if (criteria == null) {
            return true;
        }

        boolean nameMatches = !StringUtils.hasText(criteria.getLabName())
                || (lab.getLabName() != null
                && lab.getLabName().toLowerCase().contains(criteria.getLabName().toLowerCase()));
        boolean typeMatches = !StringUtils.hasText(criteria.getType())
                || (lab.getType() != null
                && lab.getType().toLowerCase().contains(criteria.getType().toLowerCase()));
        boolean buildingMatches = !StringUtils.hasText(criteria.getBuildingId())
                || (lab.getBuildingId() != null
                && lab.getBuildingId().toLowerCase().contains(criteria.getBuildingId().toLowerCase()));

        return nameMatches && typeMatches && buildingMatches;
    }

    private LabResponseDto toResponse(Lab lab) {
        LabResponseDto response = new LabResponseDto();
        response.setLabId(lab.getLabId());
        response.setLabName(lab.getLabName());
        response.setBuildingId(lab.getBuildingId());
        response.setFloor(lab.getFloor());
        response.setType(lab.getType());
        response.setInspectionTarget(lab.isInspectionTarget());
        return response;
    }
}
