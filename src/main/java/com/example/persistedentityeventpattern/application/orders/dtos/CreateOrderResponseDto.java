package com.example.persistedentityeventpattern.application.orders.dtos;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor()
@Builder()
public class CreateOrderResponseDto {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private Instant createdAt;

}