package com.example.radical;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class datascience {
    @GetMappi:ng("/datascience")
    public String dataScience()
    {
        return "learned datascience now";
    }
}
