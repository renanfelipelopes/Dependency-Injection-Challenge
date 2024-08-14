package com.example.challenge.dependencyInjection.services;

import com.example.challenge.dependencyInjection.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public Double total(Order order) {
        double shipment = shippingService.shipment(order);
        return (order.getBasic() - (order.getBasic() * (order.getDiscount() / 100))) + shipment;
    }
}
