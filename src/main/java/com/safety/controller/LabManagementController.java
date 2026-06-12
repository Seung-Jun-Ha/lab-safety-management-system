package com.safety.controller;

import com.safety.model.LabRegisterDto;
import com.safety.model.LabResponseDto;
import com.safety.service.LabManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lab")
public class LabManagementController {

    private final LabManagementService labManagementService;

    public LabManagementController(LabManagementService labManagementService) {
        this.labManagementService = labManagementService;
    }

    @PostMapping("/register")
    public ResponseEntity<LabResponseDto> registerLab(@RequestBody LabRegisterDto request) {
        LabResponseDto savedLab = labManagementService.registerLab(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLab);
    }
}
