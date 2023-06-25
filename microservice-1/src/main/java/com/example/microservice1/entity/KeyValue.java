package com.example.microservice1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "key_value")
@Data
@NoArgsConstructor
public class KeyValue implements Serializable {

    @Serial
    private static final long serialVersionUID = -8394499261175518063L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String value;

}
