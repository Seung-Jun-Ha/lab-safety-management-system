package com.safety.controller;

import com.safety.model.ChemicalSearchCriteria;
import com.safety.model.ReagentStockResponseDto;
import com.safety.service.ChemicalQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chemical")
public class ChemicalQueryController {

    private final ChemicalQueryService chemicalQueryService;

    public ChemicalQueryController(ChemicalQueryService chemicalQueryService) {
        this.chemicalQueryService = chemicalQueryService;
    }

    @GetMapping("/search")
    public List<ReagentStockResponseDto> searchChemicalStocks(@ModelAttribute ChemicalSearchCriteria criteria) {
        return chemicalQueryService.searchChemicalStocks(criteria);
    }
}
