package com.example.radical;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class datascience {
    @GetMapping("/datascience")
    public String dataScience()
    {
        return "learned datascience now test jenkins pipeline";
    }
}
