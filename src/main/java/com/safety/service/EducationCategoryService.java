package com.safety.service;

import com.safety.model.ResearcherCategoryRegisterDto;
import com.safety.model.ResearcherCategoryResponseDto;
import com.safety.model.ResearcherCategory;
import com.safety.repository.FakeEducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EducationCategoryService {

    private final FakeEducationRepository fakeEducationRepository;
    private final AlertLogService alertLogService;

    public ResearcherCategoryResponseDto registerResearcherCategory(ResearcherCategoryRegisterDto dto) {
        if (dto.getCategoryName() != null && dto.getCategoryName().length() > 30) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "카테고리 이름 글자 수 초과");
        }
        if (fakeEducationRepository.existsByCategoryName(dto.getCategoryName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "이미 존재하는 카테고리명입니다.");
        }
        ResearcherCategory category = ResearcherCategory.builder()
                .categoryId(UUID.randomUUID().toString())
                .categoryName(dto.getCategoryName())
                .description(dto.getDescription())
                .build();
        fakeEducationRepository.save(category);
        alertLogService.createLog("신규 연구활동종사자 분류 등록 완료", "EDUCATION");
        return ResearcherCategoryResponseDto.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .description(category.getDescription())
                .researcherCount(0)
                .build();
    }
}