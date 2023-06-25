package com.example.microservice1.data.repository;

import com.example.microservice1.entity.KeyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyValueRepository extends JpaRepository<KeyValue, Long> {

}
