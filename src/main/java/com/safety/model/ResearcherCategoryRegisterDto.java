package com.safety.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResearcherCategoryRegisterDto {
    private String categoryName;
    private String description;
}