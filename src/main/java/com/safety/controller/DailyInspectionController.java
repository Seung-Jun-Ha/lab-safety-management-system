package com.safety.controller;

import com.safety.model.DailyInspectionRegisterDto;
import com.safety.model.DailyInspectionResponseDto;
import com.safety.service.DailyInspectionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lab/inspection")
public class DailyInspectionController {

    private final DailyInspectionService dailyInspectionService;

    public DailyInspectionController(DailyInspectionService dailyInspectionService) {
        this.dailyInspectionService = dailyInspectionService;
    }

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody DailyInspectionRegisterDto registerDto) {
        try {
            DailyInspectionResponseDto response = dailyInspectionService.registerInspection(registerDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}