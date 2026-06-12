package com.safety.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResearcherCategory {
    private String categoryId;
    private String categoryName;
    private String description;
}