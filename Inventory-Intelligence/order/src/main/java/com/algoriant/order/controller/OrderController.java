package com.algoriant.order.controller;

import com.algoriant.order.model.Order;
import com.algoriant.order.model.OrderRequest;
import com.algoriant.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(orderService.createOrder(orderRequest), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
    @PutMapping("/modifyOrder/{id}")
    public ResponseEntity<Order> modifyOrder(@PathVariable("id") int id, @RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(orderService.modifyOrder(id, orderRequest), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
    @DeleteMapping("/removeOrder/{id}")
    public ResponseEntity<String> removeOrder(@PathVariable("id") int id) {
        orderService.removeOrder(id);
        return new ResponseEntity<>("Order removed successfully", HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @GetMapping("/getOrder/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") int id) {
        return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @GetMapping("/getAllOrder")
    public ResponseEntity<List<Order>> getAllOrder() {
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
    }
}
