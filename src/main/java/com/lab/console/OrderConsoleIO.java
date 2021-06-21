package com.lab.console;

import com.lab.domain.Order;
import com.lab.service.OrderService;

public class OrderConsoleIO {
    OrderService orderService = new OrderService();

    public void create(Order order){
        orderService.create(order);
    }
    // TODO: another CLI methods in second sprint
}
