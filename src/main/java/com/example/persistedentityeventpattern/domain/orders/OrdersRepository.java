package com.example.persistedentityeventpattern.domain.orders;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrdersRepository extends MongoRepository<Order, String> {
}