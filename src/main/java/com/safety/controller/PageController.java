package com.safety.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({
            "/",
            "/auth/register",
            "/auth/login",
            "/lab/register",
            "/lab/safety-rating",
            "/chemical/register",
            "/chemical/approval",
            "/waste/register",
            "/waste/request",
            "/check/daily",
            "/check/defect-action",
            "/education/confirm",
            "/education/warning"
    })
    public String page() {
        return "forward:/index.html";
    }
}
