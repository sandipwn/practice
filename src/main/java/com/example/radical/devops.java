package com.example.radical;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class devops {
    @GetMapping("/devops")
    public String devops()
    {
        return "first devops";
    }
}
