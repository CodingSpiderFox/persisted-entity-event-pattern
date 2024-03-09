package com.example.persistedentityeventpattern.domain.orders;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.persistedentityeventpattern.infrastructure.mail.MailService;

@Service
public class OrdersService {

    private static final Logger log = LoggerFactory.getLogger(OrdersService.class);

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private MailService mailService;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public Order processOrder(Order order) {

        Order persistedOrder = ordersRepository.save(order);

        executorService.submit(() -> {
            try {
                mailService.sendMail(persistedOrder.getEmail(), "Order received", "OrderId: " + persistedOrder.getId());
            } catch (Exception ex) {
                log.error("Error occurred", ex);
            }
        });

        return persistedOrder;
    }
}
