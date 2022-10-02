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
public class OrderCanceledProcessor {
    @ZolaMessageListener(queueName="ORDER-CANCELED", deletionPolicy = DeletionPolicy.ALWAYS)
    public void listen(String message) {
        log.info("order was canceled id: [{}]", message);
    }
}
