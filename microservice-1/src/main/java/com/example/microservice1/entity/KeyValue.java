package com.example.microservice1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "key_value")
@Data
@NoArgsConstructor
public class KeyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String value;

}
