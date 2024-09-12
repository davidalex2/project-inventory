package com.algoriant.order.service;

import com.algoriant.order.model.OrderItem;
import com.algoriant.order.model.OrderItemRequest;
import com.algoriant.order.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem createOrderItem(OrderItemRequest orderItemRequest) {
        OrderItem orderItem = OrderItem.toEntity(orderItemRequest);
        orderItemRepository.createOrderItem(orderItem.getOrderId(), orderItem.getProductId(), orderItem.getQuantity(), orderItem.getPricePerUnit(), orderItem.getTotalAmount());
        return orderItemRepository.checkOrderItem(orderItem.getOrderId(), orderItem.getProductId(), orderItem.getQuantity(), orderItem.getPricePerUnit(), orderItem.getTotalAmount());
    }

    public OrderItem modifyOrderItem(int orderItemId, OrderItemRequest orderItemRequest) {
        OrderItem orderItem = OrderItem.toEntity(orderItemRequest);
        orderItem.setOrderItemId(orderItemId);
        orderItemRepository.updateOrderItem(orderItemId, orderItem.getOrderId(), orderItem.getProductId(), orderItem.getQuantity(), orderItem.getPricePerUnit(), orderItem.getTotalAmount());
        return orderItem;
    }

    public void removeOrderItem(int orderItemId) {
        orderItemRepository.deleteOrderItemById(orderItemId);
    }

    public OrderItem getOrderItem(int orderItemId) {
        return orderItemRepository.getOrderItemById(orderItemId);
    }

    public List<OrderItem> getAllOrderItem() {
        return orderItemRepository.getAllOrderItem();
    }
}
