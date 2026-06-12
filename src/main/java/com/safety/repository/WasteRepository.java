package com.safety.repository;

import com.safety.model.WasteInfo;
import com.safety.model.WasteSearchCriteria;
import java.util.List;

public interface WasteRepository {

    WasteInfo save(WasteInfo wasteInfo);

    List<WasteInfo> findByCriteria(WasteSearchCriteria criteria);
}
