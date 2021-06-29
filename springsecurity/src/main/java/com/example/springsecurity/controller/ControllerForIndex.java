package com.example.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class ControllerForIndex {

    @GetMapping
    @PreAuthorize("hasAnyAuthority('developers:read')")
    public String getIndexPage(){
        return "index";
    }
}
