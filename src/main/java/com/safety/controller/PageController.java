package com.safety.controller;

import jakarta.servlet.http.HttpServletRequest;
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
    public String page(HttpServletRequest request) {
        String path = request.getRequestURI();
        return switch (path) {
            case "/" -> "forward:/index.html";
            case "/auth/register" -> "forward:/auth/register.html";
            case "/auth/login" -> "forward:/auth/login.html";
            case "/lab/register" -> "forward:/lab/register.html";
            case "/lab/safety-rating" -> "forward:/lab/safety-rating.html";
            case "/chemical/register" -> "forward:/chemical/register.html";
            case "/chemical/approval" -> "forward:/chemical/approval.html";
            case "/waste/register" -> "forward:/waste/register.html";
            case "/waste/request" -> "forward:/waste/request.html";
            case "/check/daily" -> "forward:/check/daily.html";
            case "/check/defect-action" -> "forward:/check/defect-action.html";
            case "/education/confirm" -> "forward:/education/confirm.html";
            case "/education/warning" -> "forward:/education/warning.html";
            default -> "forward:/index.html";
        };
    }
}
