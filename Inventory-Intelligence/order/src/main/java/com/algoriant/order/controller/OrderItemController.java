package com.algoriant.order.controller;

import com.algoriant.order.model.OrderItem;
import com.algoriant.order.model.OrderItemRequest;
import com.algoriant.order.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
    @PostMapping("/createOrderItem")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItemRequest orderItemRequest) {
        return new ResponseEntity<>(orderItemService.createOrderItem(orderItemRequest), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
    @PutMapping("/modifyOrderItem/{id}")
    public ResponseEntity<OrderItem> modifyOrderItem(@PathVariable("id") int id, @RequestBody OrderItemRequest orderItemRequest) {
        return new ResponseEntity<>(orderItemService.modifyOrderItem(id, orderItemRequest), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority(,'CUSTOMER_ADMIN')")
    @DeleteMapping("/removeOrderItem/{id}")
    public ResponseEntity<String> removeOrderItem(@PathVariable("id") int id) {
        orderItemService.removeOrderItem(id);
        return new ResponseEntity<>("OrderItem removed successfully", HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @GetMapping("/getOrderItem/{id}")
    public ResponseEntity<OrderItem> getOrderItem(@PathVariable("id") int id) {
        return new ResponseEntity<>(orderItemService.getOrderItem(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @GetMapping("/getAllOrderItem")
    public ResponseEntity<List<OrderItem>> getAllOrderItem() {
        return new ResponseEntity<>(orderItemService.getAllOrderItem(), HttpStatus.OK);
    }
}
