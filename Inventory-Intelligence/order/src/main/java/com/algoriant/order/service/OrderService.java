package com.algoriant.order.service;

import com.algoriant.order.model.Order;
import com.algoriant.order.model.OrderRequest;
import com.algoriant.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

        public Order createOrder(OrderRequest orderRequest) {
            Order order = Order.toEntity(orderRequest);
            orderRepository.createOrder(order.getCustomerName(), order.getTotalAmount(), order.getOrderDate(), order.getStatus());
        return orderRepository.checkOrder(order.getCustomerName(), order.getTotalAmount(), order.getOrderDate(), order.getStatus());
    }

        public Order modifyOrder(int orderId, OrderRequest orderRequest) {
        Order order = Order.toEntity(orderRequest);
        order.setOrderId(orderId);
        orderRepository.updateOrder(orderId, order.getCustomerName(), order.getTotalAmount(), order.getOrderDate(), order.getStatus());
        return order;
    }

    public void removeOrder(int orderId) {
        orderRepository.deleteOrderById(orderId);
    }

    public Order getOrder(int orderId) {
        return orderRepository.getOrderById(orderId);
    }

    public List<Order> getAllOrder() {
        return orderRepository.getAllOrder();
    }
}
