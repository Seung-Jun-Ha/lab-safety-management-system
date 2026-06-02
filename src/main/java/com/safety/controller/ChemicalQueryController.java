package com.safety.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chemical")
public class ChemicalQueryController {

    @GetMapping("/search")
    public void searchChemicalStocks() {
    }
}
