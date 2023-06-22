package com.example.microservice1.web.controller;

import com.example.microservice1.entity.KeyValue;
import com.example.microservice1.service.KeyValueService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/keyvalue", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@RequiredArgsConstructor
@Tag(name = "KeyValueController")
public class KeyValueController {

    private final KeyValueService keyValueService;

    @GetMapping("/all")
    public ResponseEntity<Collection<KeyValue>> findAll() {
        return ResponseEntity.ok(keyValueService.findAll());
    }

    @GetMapping
    public ResponseEntity<Collection<KeyValue>> findAll(
            @RequestParam(name = "page", required = false, defaultValue = "0") @Min(0) int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") @Min(1) int size
    ) {
        return ResponseEntity.ok(keyValueService.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findValueById(@PathVariable(name = "id") @Min(1) Long id) {
        return ResponseEntity.ok(keyValueService.findValueById(id));
    }

}
