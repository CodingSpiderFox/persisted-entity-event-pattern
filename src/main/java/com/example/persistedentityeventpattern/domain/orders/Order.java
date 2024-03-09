package com.example.persistedentityeventpattern.domain.orders;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
public class Order {

    @Getter
    @Setter
    private @Id @GeneratedValue Long id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private Instant createdAt;

}
