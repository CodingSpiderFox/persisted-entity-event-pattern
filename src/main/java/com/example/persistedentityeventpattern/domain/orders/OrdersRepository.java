package com.example.persistedentityeventpattern.domain.orders;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrdersRepository extends JpaRepository<Order, Long> {
}