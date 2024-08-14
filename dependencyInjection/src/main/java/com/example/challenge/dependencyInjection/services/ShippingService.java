package com.example.challenge.dependencyInjection.services;

import com.example.challenge.dependencyInjection.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private static final double FREE_SHIPPING_THRESHOLD = 200.00;
    private static final double DISCOUNTED_SHIPPING_THRESHOLD = 100.00;
    private static final double DISCOUNTED_SHIPPING_COST = 12.00;
    private static final double STANDARD_SHIPPING_COST = 20.00;
    private static final double FREE_SHIPPING_COST = 0.00;

    public Double shipment(Order order) {
        double basicValue = order.getBasic();

        if (basicValue < DISCOUNTED_SHIPPING_THRESHOLD) {
            return STANDARD_SHIPPING_COST;
        } else if (basicValue <= FREE_SHIPPING_THRESHOLD) {
            return DISCOUNTED_SHIPPING_COST;
        } else {
            return FREE_SHIPPING_COST;
        }
    }
}
