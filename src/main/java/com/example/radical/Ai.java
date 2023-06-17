package com.example.radical;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ai {
    @GetMapping("/Ai")
    public String dataScience()
    {
        return "learned Ai now";
    }
}

