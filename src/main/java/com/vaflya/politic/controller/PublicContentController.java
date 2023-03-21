package com.vaflya.politic.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublicContentController {

    @GetMapping(value = "")
    public String getPublicIndex() {
        return "capy.jpg";
    }
}
