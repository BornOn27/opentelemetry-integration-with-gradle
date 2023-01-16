package com.flodeus.integration.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health-check")
public class Probe {

    @GetMapping
    public Map healthCheck(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");

        return response;
    }
}
