package com.wonit.deliveryservice.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Order {
    String orderId;
    String address;
    int price;
}
