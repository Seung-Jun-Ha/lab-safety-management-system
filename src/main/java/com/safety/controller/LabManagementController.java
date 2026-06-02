package com.safety.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lab")
public class LabManagementController {

    @PostMapping("/register")
    public void registerLab() {
    }
}
