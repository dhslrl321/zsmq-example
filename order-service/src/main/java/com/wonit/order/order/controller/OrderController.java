package com.wonit.order.order.controller;

import com.wonit.order.order.messaging.MessagePublisher;
import com.wonit.order.order.domain.Order;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private static final Order[] SAMPLE_ORDERS = {
            Order.of(UUID.randomUUID().toString(), "Seoul", 125_000_000),
            Order.of(UUID.randomUUID().toString(), "New York", 25_602_900),
            Order.of(UUID.randomUUID().toString(), "singapore", 5_120_000),
            Order.of(UUID.randomUUID().toString(), "tokyo", 9_000_000),
    };

    private final MessagePublisher publisher;

    @GetMapping("/orders/{index}/confirm")
    public boolean confirm(@PathVariable int index) {
        try {
            Order order = SAMPLE_ORDERS[index];
            publisher.sendConfirmedMessage(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/orders/{index}/cancel")
    public boolean cancel(@PathVariable int index) {
        try {
            String orderId = SAMPLE_ORDERS[index].getOrderId();
            publisher.sendCanceledMessage(orderId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
