package com.algoriant.order.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "OrderItem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private int orderItemId;
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price_per_unit")
    private BigDecimal pricePerUnit;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    public OrderItem() {
    }

    public OrderItem(int orderItemId, int orderId, int productId, int quantity, BigDecimal pricePerUnit, BigDecimal totalAmount) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalAmount = totalAmount;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static OrderItem toEntity(OrderItemRequest orderItemRequest) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(orderItemRequest.getOrderId());
        orderItem.setProductId(orderItemRequest.getProductId());
        orderItem.setQuantity(orderItemRequest.getQuantity());
        orderItem.setPricePerUnit(orderItemRequest.getPricePerUnit());
        orderItem.setTotalAmount(orderItemRequest.getTotalAmount());
        return orderItem;
    }
}
