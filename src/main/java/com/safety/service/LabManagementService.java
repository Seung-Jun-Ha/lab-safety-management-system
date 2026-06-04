package com.safety.service;

import java.util.UUID;

import com.safety.model.Lab;
import com.safety.model.LabRegisterDto;
import com.safety.model.LabResponseDto;
import com.safety.repository.LabRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LabManagementService {

	private final LabRepository labRepository;
	private final AlertLogService alertLogService;

	public LabManagementService(LabRepository labRepository, AlertLogService alertLogService) {
		this.labRepository = labRepository;
		this.alertLogService = alertLogService;
	}

	public LabResponseDto registerLab(LabRegisterDto request) {
		if (request == null || !StringUtils.hasText(request.getLabName())) {
			throw new IllegalArgumentException("연구실명은 필수입니다.");
		}

		Lab lab = new Lab();
		lab.setLabId(UUID.randomUUID().toString());
		lab.setLabName(request.getLabName());
		lab.setBuildingId(request.getBuildingId());
		lab.setFloor(request.getFloor() == null ? 0 : request.getFloor());
		lab.setType(request.getType());
		lab.setInspectionTarget(request.getInspectionTarget() != null && request.getInspectionTarget());

		Lab savedLab = labRepository.save(lab);
		alertLogService.createLog("신규 연구실 기본정보 등록 완료", "LAB");

		return toResponse(savedLab);
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
