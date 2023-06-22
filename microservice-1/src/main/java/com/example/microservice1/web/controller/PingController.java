package com.example.microservice1.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "PingController")
public class PingController {

    @GetMapping(path = "/ping")
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok().build();
    }

}
