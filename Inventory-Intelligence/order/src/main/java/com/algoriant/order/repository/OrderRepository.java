package com.algoriant.order.repository;

import com.algoriant.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Query(value = "INSERT INTO orders (customer_name, total_amount, order_date, status, created_at) VALUES ( :customerName, :totalAmount, :orderDate, :status, now())", nativeQuery = true)
    void createOrder(@Param("customerName") String customerName, @Param("totalAmount") BigDecimal totalAmount, @Param("orderDate") Date orderDate, @Param("status") String status);

    @Query(value = "SELECT * FROM orders WHERE customer_name = :customerName AND total_amount = :totalAmount AND order_date = :orderDate AND status = :status ORDER BY order_id DESC LIMIT 1", nativeQuery = true)
    Order checkOrder(@Param("customerName") String customerName, @Param("totalAmount") BigDecimal totalAmount, @Param("orderDate") Date orderDate, @Param("status") String status);

    @Modifying
    @Query(value = "UPDATE orders SET customer_name = :customerName, total_amount = :totalAmount, order_date = :orderDate, status = :status WHERE order_id = :orderId", nativeQuery = true)
    void updateOrder(@Param("orderId") int orderId, @Param("customerName") String customerName, @Param("totalAmount") BigDecimal totalAmount, @Param("orderDate") Date orderDate, @Param("status") String status);
    @Modifying
    @Query(value = "DELETE FROM orders WHERE order_id = :orderId", nativeQuery = true)
    void deleteOrderById(@Param("orderId") int orderId);

    @Query(value = "SELECT * FROM orders WHERE order_id = :orderId", nativeQuery = true)
    Order getOrderById(@Param("orderId") int orderId);

    @Query(value = "SELECT * FROM orders", nativeQuery = true)
    List<Order> getAllOrder();
}
