package com.database.eventmania.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    @GetMapping()
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView("login.html");
        return mav;
    }
}