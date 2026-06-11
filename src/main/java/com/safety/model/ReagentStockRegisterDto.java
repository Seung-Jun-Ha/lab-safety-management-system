package com.safety.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReagentStockRegisterDto {

    @NotBlank(message = "연구실 ID는 필수입니다.")
    private String labId;

    @NotBlank(message = "화학제품 ID는 필수입니다.")
    private String productId;

    @NotNull(message = "등록 수량은 필수입니다.")
    private Double quantity;

    @NotBlank(message = "단위는 필수입니다.")
    private String unit;

    @NotBlank(message = "보관 위치는 필수입니다.")
    private String location;

    public ReagentStockRegisterDto() {
    }

    public ReagentStockRegisterDto(String labId, String productId, Double quantity, String unit, String location) {
        this.labId = labId;
        this.productId = productId;
        this.quantity = quantity;
        this.unit = unit;
        this.location = location;
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
}
