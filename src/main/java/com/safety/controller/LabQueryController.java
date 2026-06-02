package com.safety.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lab")
public class LabQueryController {

    @GetMapping("/search")
    public void searchLabs() {
    }
}
