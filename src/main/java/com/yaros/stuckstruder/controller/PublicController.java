package com.yaros.stuckstruder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicController {
    @GetMapping({"/","index"})
    public String index(){
        return "index";
    }
}
