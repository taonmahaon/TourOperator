package com.lab.service;

import com.lab.dao.OrderDao;
import com.lab.domain.Order;

public class OrderService {
    OrderDao orderDao = new OrderDao();

    public Order create(Order order){
       return orderDao.create(order);
    }

    // TODO: another services in second sprint
}
