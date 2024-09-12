package com.algoriant.inventory.controller;


import com.algoriant.inventory.model.Inventory;
import com.algoriant.inventory.model.InventoryRequest;
import com.algoriant.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/inventoryController")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @PostMapping("/createInventory")
    public ResponseEntity<String> createInventory(@RequestBody InventoryRequest inventoryRequest){
        service.createInventory(inventoryRequest);
        return new ResponseEntity<>("CREATE SUCCESSFULLY", HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @DeleteMapping("/deleteInventory/{id}")
    public ResponseEntity<String> removeInventory(@PathVariable("id") String id){
        service.removeInventory(id);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @PutMapping("/modifyInventory")
    public ResponseEntity<String> modifyInventory(@RequestBody InventoryRequest inventoryRequest){
        service.modifyInventory(inventoryRequest);
        return new ResponseEntity<>( "UPDATE SUCCESSFULLY",HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @GetMapping("/getAllInventory")
    public ResponseEntity<List<Inventory>> getAllInventory(){
        List<Inventory> inventoryDTOList = service.getAllInventory();
        return new ResponseEntity<>(inventoryDTOList,HttpStatus.OK);
    }


    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @GetMapping("/getInventoryById/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") String id){
        return new ResponseEntity<>(service.getInventory(id),HttpStatus.OK);
    }

}
