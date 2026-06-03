package com.safety.repository;

import com.safety.model.WasteInfo;
import com.safety.model.WasteSearchCriteria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class FakeWasteRepository implements WasteRepository {

    private final List<WasteInfo> wasteInfos = new ArrayList<>();

    @Override
    public synchronized WasteInfo save(WasteInfo wasteInfo) {
        wasteInfos.add(wasteInfo);
        return wasteInfo;
    }

    @Override
    public synchronized List<WasteInfo> findByCriteria(WasteSearchCriteria criteria) {
        return wasteInfos.stream()
            .filter(wasteInfo -> isBlank(criteria.getLabId()) || criteria.getLabId().equals(wasteInfo.getLabId()))
            .filter(wasteInfo -> isBlank(criteria.getTypeId()) || criteria.getTypeId().equals(wasteInfo.getTypeId()))
            .toList();
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
