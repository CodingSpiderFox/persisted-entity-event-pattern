package com.example.persistedentityeventpattern.application.orders.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor()
@Builder()
public class CreateOrderResponseDto {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String email;
}