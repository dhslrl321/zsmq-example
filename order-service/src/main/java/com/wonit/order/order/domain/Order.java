package com.wonit.order.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value(staticConstructor = "of")
public class Order {
    String orderId;
    String address;
    int price;
}
