package com.safety.service;

import com.safety.model.EducationSearchCriteria;
import com.safety.model.ResearcherCategoryResponseDto;
import com.safety.model.UserSearchCriteria;
import com.safety.repository.FakeEducationRepository;
import com.safety.repository.FakeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationQueryService {

    private final FakeEducationRepository fakeEducationRepository;
    private final FakeUserRepository fakeUserRepository;

    public List<ResearcherCategoryResponseDto> getResearcherCategories(EducationSearchCriteria criteria) {
        return fakeEducationRepository.findAll().stream()
                .filter(c -> criteria.getCategoryName() == null || c.getCategoryName().contains(criteria.getCategoryName()))
                .map(c -> {
                    int count = (int) fakeUserRepository.searchUsers(new UserSearchCriteria()).stream()
                            .filter(user -> c.getCategoryId().equals(user.getDeptId()))
                            .count();
                    return ResearcherCategoryResponseDto.builder()
                            .categoryId(c.getCategoryId())
                            .categoryName(c.getCategoryName())
                            .description(c.getDescription())
                            .researcherCount(count)
                            .build();
                })
                .collect(Collectors.toList());
    }
}