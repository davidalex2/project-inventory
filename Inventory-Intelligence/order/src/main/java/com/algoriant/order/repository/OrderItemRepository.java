package com.algoriant.order.repository;

import com.algoriant.order.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    @Modifying
    @Query(value = "INSERT INTO order_item (order_id, product_id, quantity, price_per_unit, total_amount) VALUES ( :orderId, :productId, :quantity, :pricePerUnit, :totalAmount)", nativeQuery = true)
    void createOrderItem(@Param("orderId") int orderId, @Param("productId") int productId, @Param("quantity") int quantity, @Param("pricePerUnit") BigDecimal pricePerUnit, @Param("totalAmount") BigDecimal totalAmount);

    @Query(value = "SELECT * FROM order_item WHERE order_id = :orderId AND product_id = :productId AND quantity = :quantity AND price_per_unit = :pricePerUnit AND total_amount = :totalAmount ORDER BY order_item_id DESC LIMIT 1", nativeQuery = true)
    OrderItem checkOrderItem(@Param("orderId") int orderId, @Param("productId") int productId, @Param("quantity") int quantity, @Param("pricePerUnit") BigDecimal pricePerUnit, @Param("totalAmount") BigDecimal totalAmount);

    @Modifying
    @Query(value = "UPDATE order_item SET order_id = :orderId, product_id = :productId, quantity = :quantity, price_per_unit = :pricePerUnit, total_amount = :totalAmount WHERE order_item_id = :orderItemId", nativeQuery = true)
    void updateOrderItem(@Param("orderItemId") int orderItemId, @Param("orderId") int orderId, @Param("productId") int productId, @Param("quantity") int quantity, @Param("pricePerUnit") BigDecimal pricePerUnit, @Param("totalAmount") BigDecimal totalAmount);
    @Modifying
    @Query(value = "DELETE FROM order_item WHERE order_item_id = :orderItemId", nativeQuery = true)
    void deleteOrderItemById(@Param("orderItemId") int orderItemId);

    @Query(value = "SELECT * FROM order_item WHERE order_item_id = :orderItemId", nativeQuery = true)
    OrderItem getOrderItemById(@Param("orderItemId") int orderItemId);

    @Query(value = "SELECT * FROM order_item", nativeQuery = true)
    List<OrderItem> getAllOrderItem();
}
