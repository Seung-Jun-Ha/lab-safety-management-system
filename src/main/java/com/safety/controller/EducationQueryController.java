package com.safety.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/education")
public class EducationQueryController {

    @GetMapping("/search")
    public void searchEducationRecords() {
    }
}
