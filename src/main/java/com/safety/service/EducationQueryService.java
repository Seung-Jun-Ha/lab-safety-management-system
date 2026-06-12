package com.safety.service;

import com.safety.model.EducationSearchCriteria;
import com.safety.model.ResearcherCategoryResponseDto;
import com.safety.repository.FakeEducationRepository;
import com.safety.repository.FakeUserRepository; // 1번 유저 가상 DB 조인 연계
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationQueryService {

    private final FakeEducationRepository fakeEducationRepository;
    private final FakeUserRepository fakeUserRepository; // 실시간 통계 카운트용 주입

    public List<ResearcherCategoryResponseDto> getResearcherCategories(EducationSearchCriteria criteria) {
        return fakeEducationRepository.findAll().stream()
                .filter(c -> criteria.getCategoryName() == null || c.getCategoryName().contains(criteria.getCategoryName()))
                .map(c -> {
                    // ⭕ 빌드 실패 우회: 승준이의 FakeUserRepository 메서드명 미지정으로 인해 임시 0명 처리
                    int count = 0;

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