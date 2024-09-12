package com.algoriant.inventory.model;

import javax.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import static java.lang.String.valueOf;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(name = "item_id")
    private String itemId;
    @Column(name = "product_id")
    private BigInteger productId;

    @Column(name = " quantity")
    private BigInteger quantity;

    @Column(name = "zone_id")
    private UUID zoneId;
    @Column(name="last_updated")
    private Timestamp lastUpdated;

    public Inventory() {
    }

    public Inventory(String itemId, BigInteger productId, UUID zoneId,Timestamp lastUpdated, BigInteger quantity) {
        this.itemId = itemId;
        this.productId = productId;
        this.zoneId = zoneId;
        this.lastUpdated=lastUpdated;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public UUID getZoneId() {
        return zoneId;
    }

    public void setZoneId(UUID zoneId) {
        this.zoneId = zoneId;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        quantity = quantity;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Inventory toEntity(InventoryRequest request){
        Inventory inventory = new Inventory();
        inventory.setItemId(request.getItemId());
        inventory.setZoneId(request.getZoneId());
        inventory.setProductId(request.getProductId());
        return inventory;
    }
}
