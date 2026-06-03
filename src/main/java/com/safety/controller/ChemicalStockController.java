package com.safety.controller;

import com.safety.model.ReagentStockRegisterDto;
import com.safety.model.ReagentStockResponseDto;
import com.safety.service.ChemicalStockService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/chemical")
public class ChemicalStockController {

    private final ChemicalStockService chemicalStockService;

    public ChemicalStockController(ChemicalStockService chemicalStockService) {
        this.chemicalStockService = chemicalStockService;
    }

    @PostMapping("/stock/register")
    public ResponseEntity<ReagentStockResponseDto> registerChemicalStock(
            @Valid @RequestBody ReagentStockRegisterDto request
    ) {
        ReagentStockResponseDto response = chemicalStockService.registerChemicalStock(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(Map.of("message", exception.getMessage()));
    }
}
