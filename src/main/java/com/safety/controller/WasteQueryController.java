package com.safety.controller;

import com.safety.model.WasteInfoResponseDto;
import com.safety.model.WasteSearchCriteria;
import com.safety.service.WasteQueryService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/waste")
public class WasteQueryController {

    private final WasteQueryService wasteQueryService;

    public WasteQueryController(WasteQueryService wasteQueryService) {
        this.wasteQueryService = wasteQueryService;
    }

    @GetMapping("/search")
    public List<WasteInfoResponseDto> searchWasteInfo(@ModelAttribute WasteSearchCriteria criteria) {
        return wasteQueryService.searchWasteInfo(criteria);
    }
}
