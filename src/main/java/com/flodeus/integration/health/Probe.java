package com.flodeus.integration.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health-check")
public class Probe {

    @GetMapping("")
    public ResponseEntity healthCheck(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");

        return ResponseEntity.ok(response);
    }
}
