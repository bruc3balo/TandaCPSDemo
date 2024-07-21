package com.tanda.cps_demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingCheck {

    @GetMapping("ping")
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok().build();
    }
}