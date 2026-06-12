package com.safety.controller;

import com.safety.model.WasteInfoRegisterDto;
import com.safety.model.WasteInfoResponseDto;
import com.safety.service.WasteManagementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/waste")
public class WasteManagementController {

    private final WasteManagementService wasteManagementService;

    public WasteManagementController(WasteManagementService wasteManagementService) {
        this.wasteManagementService = wasteManagementService;
    }

    @PostMapping("/register")
    public ResponseEntity<WasteInfoResponseDto> registerWasteInfo(@Valid @RequestBody WasteInfoRegisterDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(wasteManagementService.registerWasteInfo(request));
    }
}
