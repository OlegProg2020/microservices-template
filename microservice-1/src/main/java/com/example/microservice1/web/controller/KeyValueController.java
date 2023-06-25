package com.example.microservice1.web.controller;

import com.example.microservice1.entity.KeyValue;
import com.example.microservice1.service.KeyValueService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/keyvalue", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class KeyValueController {

    private final KeyValueService keyValueService;

    @GetMapping("/all")
    public ResponseEntity<Collection<KeyValue>> findAll() {
        return ResponseEntity.ok(keyValueService.findAll());
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = KeyValue.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    content = @Content,
                    description = "Invalid value of the page or size parameters"
            )
    })
    @GetMapping
    public ResponseEntity<Collection<KeyValue>> findAll(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(keyValueService.findAll(page, size));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = String.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    content = @Content,
                    description = "Invalid value of the id parameter"
            ),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "Value with such key was not found"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<String> findValueById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(keyValueService.findValueById(id));
    }

}
