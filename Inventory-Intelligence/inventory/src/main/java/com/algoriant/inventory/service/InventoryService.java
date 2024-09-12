package com.algoriant.inventory.service;

import com.algoriant.inventory.model.Inventory;
import com.algoriant.inventory.model.InventoryRequest;
import com.algoriant.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;



    public void createInventory(InventoryRequest request){

        repository.insertInventory(request.getItemId(),request.getProductId(),request.getZoneId(),request.getQuantity());
    }
//    public static String base64Encode(String plainText) {
//        byte[] plainTextBytes = plainText.getBytes();
//        return Base64.getEncoder().encodeToString(plainTextBytes);
//    }
    public void removeInventory(String itemId ){
        repository.deleteInventory(itemId);
    }
    public void modifyInventory(InventoryRequest inventoryRequest ){
       repository.updateInventory(inventoryRequest.getProductId(),inventoryRequest.getQuantity(),inventoryRequest.getZoneId(),inventoryRequest.getItemId());
    }

    public Inventory getInventory(String itemId ){
        Optional<Inventory> optionalInventory = Optional.of(repository.findInventoryById(itemId));
        if(optionalInventory.isPresent()){
            return optionalInventory.get();
        }
        return   null;
    }

    public List<Inventory> getAllInventory(){
        return repository.findAllInventory();
    }


}
