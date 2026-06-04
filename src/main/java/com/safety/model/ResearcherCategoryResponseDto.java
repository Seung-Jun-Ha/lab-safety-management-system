package com.safety.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResearcherCategoryResponseDto {
    private String categoryId;
    private String categoryName;
    private String description;
    private int researcherCount;
}