package com.safety.controller;

import com.safety.model.DailyInspectionSummaryDto;
import com.safety.model.InspectionSearchCriteria;
import com.safety.service.DailyInspectionQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lab/inspection/search")
public class DailyInspectionQueryController {

    private final DailyInspectionQueryService dailyInspectionQueryService;

    public DailyInspectionQueryController(DailyInspectionQueryService dailyInspectionQueryService) {
        this.dailyInspectionQueryService = dailyInspectionQueryService;
    }

    @GetMapping
    public ResponseEntity<List<DailyInspectionSummaryDto>> getDashboardSummary(
            @ModelAttribute InspectionSearchCriteria criteria) {
        List<DailyInspectionSummaryDto> summaryList = dailyInspectionQueryService.searchSummary(criteria);
        return ResponseEntity.ok(summaryList);
    }
}