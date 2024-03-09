package com.example.persistedentityeventpattern.infrastructure.mail;

import java.util.Random;

import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

@Service
public class MailService {

    @SneakyThrows
    public void sendMail(String recipient, String subject, String message) {
        // simulate log running send process
        Thread.sleep(3000);
        
        // simulate occasional failure with roughly 50 percent chance
        final Random random = new Random();
        if (random.nextBoolean()) {
            throw new Exception("Mail sending failed");
        }
    }
}
 