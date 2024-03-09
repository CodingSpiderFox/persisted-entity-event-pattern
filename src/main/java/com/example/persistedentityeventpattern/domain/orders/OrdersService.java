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

        if (order == null) {
            return null;
        }

        Order persistedOrder = ordersRepository.save(order);

        executorService.submit(() -> {
            doActions(persistedOrder);
        });

        return persistedOrder;
    }

    private void doActions(Order order) {
        try {
            mailService.sendMail(order.getEmail(), "Order received", "OrderId: " + order.getId());
        } catch (Exception ex) {
            log.error("Error occurred", ex);
            return;
        }
        
        log.info("Sent mail");
    }
}
