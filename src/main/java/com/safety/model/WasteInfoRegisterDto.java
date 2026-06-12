package com.safety.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public class WasteInfoRegisterDto {

    @NotBlank
    private String typeId;

    @NotBlank
    private String labId;

    @NotNull
    @Positive
    private Double quantity;

    @NotBlank
    private String unit;

    @NotNull
    @PastOrPresent
    private LocalDate generatedDate;

    public WasteInfoRegisterDto() {
    }

    public WasteInfoRegisterDto(String typeId, String labId, Double quantity, String unit, LocalDate generatedDate) {
        this.typeId = typeId;
        this.labId = labId;
        this.quantity = quantity;
        this.unit = unit;
        this.generatedDate = generatedDate;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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
