package com.safety.controller;

import com.safety.model.ResearcherCategoryRegisterDto;
import com.safety.model.ResearcherCategoryResponseDto;
import com.safety.service.EducationCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/education/categories")
@RequiredArgsConstructor
public class EducationCategoryController {

    private final EducationCategoryService educationCategoryService;

    @PostMapping
    public ResponseEntity<ResearcherCategoryResponseDto> registerResearcherCategory(
            @RequestBody ResearcherCategoryRegisterDto dto) {
        ResearcherCategoryResponseDto response = educationCategoryService.registerResearcherCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}