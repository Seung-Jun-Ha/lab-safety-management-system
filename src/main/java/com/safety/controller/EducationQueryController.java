package com.safety.controller;

import com.safety.model.EducationSearchCriteria;
import com.safety.model.ResearcherCategoryResponseDto;
import com.safety.service.EducationQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/education/queries")
@RequiredArgsConstructor
public class EducationQueryController {

    private final EducationQueryService educationQueryService;

    @GetMapping
    public ResponseEntity<List<ResearcherCategoryResponseDto>> getResearcherCategories(
            EducationSearchCriteria criteria) {
        List<ResearcherCategoryResponseDto> list = educationQueryService.getResearcherCategories(criteria);
        return ResponseEntity.ok(list);
    }
}