package com.example.microservice1.web.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PingController {

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content
            )
    })
    @GetMapping(path = "/ping")
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok().build();
    }

}
