package com.leszeksz.passwordmanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping()
    public String loginPage() {
        return "index";
    }
}
