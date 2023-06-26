package com.example.microservice1.service;

import com.example.microservice1.entity.KeyValue;
import jakarta.validation.constraints.Min;

import java.util.Collection;

public interface KeyValueService {

    Collection<KeyValue> findAll();
    Collection<KeyValue> findAll(@Min(0) int page, @Min(1) int size);
    String findValueById(@Min(1) Long id);

}
