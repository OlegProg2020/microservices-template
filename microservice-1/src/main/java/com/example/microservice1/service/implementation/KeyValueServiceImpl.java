package com.example.microservice1.service.implementation;

import com.example.microservice1.data.repository.KeyValueRepository;
import com.example.microservice1.entity.KeyValue;
import com.example.microservice1.exception.DataMissingException;
import com.example.microservice1.service.KeyValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class KeyValueServiceImpl implements KeyValueService {

    private final KeyValueRepository keyValueRepository;

    @Override
    public Collection<KeyValue> findAll() {
        return keyValueRepository.findAll();
    }

    @Override
    public Collection<KeyValue> findAll(int page, int size) {
        Pageable request = PageRequest.of(page, size);
        return keyValueRepository.findAll(request).getContent();
    }

    @Override
    public String findValueById(Long id) {
        return keyValueRepository.findById(id).orElseThrow(DataMissingException::new).getValue();
    }

}
