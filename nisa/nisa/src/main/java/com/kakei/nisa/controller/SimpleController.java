package com.kakei.nisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    @GetMapping("/simple")
    public String simple() {
        return "simple";
    }
}