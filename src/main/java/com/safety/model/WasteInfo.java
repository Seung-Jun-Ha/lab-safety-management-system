package com.safety.model;

import java.time.LocalDate;

public class WasteInfo {

    private String wasteId;
    private String typeId;
    private String typeName;
    private String labId;
    private Double quantity;
    private String unit;
    private LocalDate generatedDate;

    public WasteInfo() {
    }

    public WasteInfo(String wasteId, String typeId, String typeName, String labId, Double quantity, String unit, LocalDate generatedDate) {
        this.wasteId = wasteId;
        this.typeId = typeId;
        this.typeName = typeName;
        this.labId = labId;
        this.quantity = quantity;
        this.unit = unit;
        this.generatedDate = generatedDate;
    }

    public String getWasteId() {
        return wasteId;
    }

    public void setWasteId(String wasteId) {
        this.wasteId = wasteId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
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

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }
}
