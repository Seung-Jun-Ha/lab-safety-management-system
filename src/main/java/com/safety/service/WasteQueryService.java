package com.safety.service;

import com.safety.model.WasteInfoResponseDto;
import com.safety.model.WasteSearchCriteria;
import com.safety.repository.WasteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WasteQueryService {

    private final WasteRepository wasteRepository;

    public WasteQueryService(WasteRepository wasteRepository) {
        this.wasteRepository = wasteRepository;
    }

    public List<WasteInfoResponseDto> searchWasteInfo(WasteSearchCriteria criteria) {
        WasteSearchCriteria safeCriteria = criteria == null ? new WasteSearchCriteria() : criteria;

        return wasteRepository.findByCriteria(safeCriteria).stream()
            .map(WasteInfoResponseDto::from)
            .toList();
    }
}
