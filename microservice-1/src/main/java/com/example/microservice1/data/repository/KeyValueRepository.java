package com.example.microservice1.data.repository;

import com.example.microservice1.entity.KeyValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyValueRepository extends JpaRepository<KeyValue, Long> {

}
