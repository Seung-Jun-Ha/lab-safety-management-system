package com.safety.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/education")
public class EducationCategoryController {

    @PostMapping("/category/register")
    public void registerEducationCategory() {
    }
}
