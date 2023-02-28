package com.yaros.stuckstruder.controller;

import org.springframework.stereotype.Controller;

@Controller
public class PDFController {
    public String getPdf(){
        return "getPdfFile";
    }
}
