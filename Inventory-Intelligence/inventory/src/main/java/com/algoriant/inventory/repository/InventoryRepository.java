package com.algoriant.inventory.repository;

import com.algoriant.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {

    @Modifying
    @Query(value = "INSERT INTO inventory (item_id,product_id,zone_id,quantity) VALUES (:itemId,:productId,:zoneId,:quantity)",nativeQuery = true)
    @Transactional
    void insertInventory(@Param("itemId") String itemId,@Param("productId") BigInteger productId,@Param("zoneId") UUID zoneId, @Param("quantity") BigInteger quantity);


    @Modifying
    @Transactional
    @Query(value = "UPDATE inventory SET product_id = :productId, zone_id = :zoneId, quantity = :quantity WHERE item_id = :itemId",nativeQuery = true)
    void updateInventory(@Param("productId") BigInteger productId,@Param("quantity") BigInteger quantity, @Param("zoneId") UUID zoneId,@Param("itemId") String itemId);

    @Query(value = "SELECT * FROM inventory",nativeQuery = true)
    List<Inventory> findAllInventory();

    @Query(value = "SELECT * FROM inventory WHERE item_id = :itemId ",nativeQuery = true)
    Inventory findInventoryById(@Param("itemId") String itemId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM inventory WHERE item_id = :itemId",nativeQuery = true)
    void deleteInventory(@Param("itemId") String itemId);


}
