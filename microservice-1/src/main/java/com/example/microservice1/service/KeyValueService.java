package com.example.microservice1.service;

import com.example.microservice1.entity.KeyValue;

import java.util.Collection;

public interface KeyValueService {

    Collection<KeyValue> findAll();
    Collection<KeyValue> findAll(int page, int size);
    String findValueById(Long id);

}
