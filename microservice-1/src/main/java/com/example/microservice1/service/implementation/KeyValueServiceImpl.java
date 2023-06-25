package com.example.microservice1.service.implementation;

import com.example.microservice1.data.repository.KeyValueRepository;
import com.example.microservice1.entity.KeyValue;
import com.example.microservice1.exception.DataMissingException;
import com.example.microservice1.service.KeyValueService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Validated
public class KeyValueServiceImpl implements KeyValueService {

    private final KeyValueRepository keyValueRepository;

    @Override
    @Cacheable(value = "keyValueEntities")
    public Collection<KeyValue> findAll() {
        return keyValueRepository.findAll();
    }

    @Override
    @Cacheable(value = "keyValueEntities")
    public Collection<KeyValue> findAll(@Min(0) int page, @Min(1) int size) {
        Pageable request = PageRequest.of(page, size);
        return keyValueRepository.findAll(request).getContent();
    }

    @Override
    @Cacheable(value = "keyValueEntities")
    public String findValueById(@Min(1) Long id) {
        return keyValueRepository.findById(id).orElseThrow(DataMissingException::new).getValue();
    }

}
