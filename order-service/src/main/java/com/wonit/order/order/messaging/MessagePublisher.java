package com.wonit.order.order.messaging;

import com.github.dhslrl321.zsmq.client.ZolaQueueMessageTemplate;
import com.wonit.order.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessagePublisher {

    private final ZolaQueueMessageTemplate template;

    public void sendConfirmedMessage(Order order) {
        template.convertAndSend("ORDER-CONFIRMED", order);
    }

    public void sendCanceledMessage(String orderId) {
        template.convertAndSend("ORDER-CANCELED", orderId);
    }
}
