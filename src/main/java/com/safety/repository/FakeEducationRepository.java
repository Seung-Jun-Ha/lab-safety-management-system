package com.safety.repository;

import com.safety.model.ResearcherCategory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeEducationRepository {
    // 가상 데이터베이스 역할을 하는 메모리 리스트
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