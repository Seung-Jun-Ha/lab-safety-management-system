package com.safety.repository;

import com.safety.model.ResearcherCategory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeEducationRepository {

    private final List<ResearcherCategory> store = new ArrayList<>();

    public ResearcherCategory save(ResearcherCategory category) {
        store.add(category);
        return category;
    }

    public List<ResearcherCategory> findAll() {
        return new ArrayList<>(store);
    }

    public boolean existsByCategoryName(String categoryName) {
        return store.stream()
                .anyMatch(c -> c.getCategoryName().equals(categoryName));
    }
}