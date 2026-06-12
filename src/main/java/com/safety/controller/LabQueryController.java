package com.safety.controller;

import java.util.List;

import com.safety.model.LabResponseDto;
import com.safety.model.LabSearchCriteria;
import com.safety.service.LabQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lab")
public class LabQueryController {

    private final LabQueryService labQueryService;

    public LabQueryController(LabQueryService labQueryService) {
        this.labQueryService = labQueryService;
    }

    @GetMapping("/search")
    public List<LabResponseDto> searchLabs(@ModelAttribute LabSearchCriteria criteria) {
        return labQueryService.searchLabs(criteria);
    }
}
