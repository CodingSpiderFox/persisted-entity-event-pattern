package com.example.persistedentityeventpattern.application.orders.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor()
@NoArgsConstructor()
@Builder()
 public class CreateOrderRequestDto {

    @Getter
    @Setter
    private String email;
}