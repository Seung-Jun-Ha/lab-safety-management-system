package com.safety.repository;

import com.safety.model.ChemicalProduct;
import com.safety.model.ChemicalSearchCriteria;
import com.safety.model.ReagentStock;

import java.util.List;
import java.util.Optional;

public interface ChemicalRepository {

    ReagentStock save(ReagentStock reagentStock);

    List<ReagentStock> findByCriteria(ChemicalSearchCriteria criteria);

    Optional<ChemicalProduct> findProductById(String productId);
}
