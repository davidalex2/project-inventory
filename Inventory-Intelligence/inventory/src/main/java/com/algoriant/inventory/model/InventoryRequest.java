package com.algoriant.inventory.model;

import java.math.BigInteger;
import java.util.UUID;

public class InventoryRequest {

    private String itemId;
    private BigInteger productId;

    private BigInteger quantity;

    private UUID zoneId;

    public InventoryRequest() {
    }

    public InventoryRequest(String itemId, BigInteger productId, UUID zoneId,BigInteger quantity) {
        this.itemId = itemId;
        this.productId = productId;
        this.zoneId = zoneId;
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
        this.quantity = quantity;
    }
}
