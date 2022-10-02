package com.wonit.deliveryservice.messaging;

import com.github.dhslrl321.zsmq.annotation.ZolaConsumer;
import com.github.dhslrl321.zsmq.annotation.ZolaMessageListener;
import com.github.dhslrl321.zsmq.commons.ZolaJsonSerializer;
import com.github.dhslrl321.zsmq.listener.DeletionPolicy;
import com.wonit.deliveryservice.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@ZolaConsumer
@Slf4j
public class OrderConfirmedProcessor {

    @ZolaMessageListener(queueName="ORDER-CONFIRMED", deletionPolicy = DeletionPolicy.ALWAYS)
    public void listen(String message) {
        log.info("json : {}", message);
        Order order = ZolaJsonSerializer.getInstance().deserialize(message, Order.class);
        log.info("order was confirmed : id : {}, address: {}, price: {}", order.getOrderId(), order.getAddress(), order.getPrice());
    }
}
