package com.safety.model;

import java.time.LocalDateTime;

public class ReagentStock {

    private String stockId;
    private String labId;
    private String productId;
    private Double quantity;
    private String unit;
    private String location;
    private LocalDateTime registeredAt;

    public ReagentStock() {
    }

    public ReagentStock(
            String stockId,
            String labId,
            String productId,
            Double quantity,
            String unit,
            String location,
            LocalDateTime registeredAt
    ) {
        this.stockId = stockId;
        this.labId = labId;
        this.productId = productId;
        this.quantity = quantity;
        this.unit = unit;
        this.location = location;
        this.registeredAt = registeredAt;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}
