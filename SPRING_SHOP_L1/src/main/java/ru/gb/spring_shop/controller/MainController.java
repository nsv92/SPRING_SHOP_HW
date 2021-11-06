package ru.gb.spring_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    public MainController() {
    }

    @GetMapping("/login")
    public String showMyLoginPage() {
        return "login";
    }

    @GetMapping("/hello")
    public String showHelloWorldPage() {
        return "hello_world";
    }
}
