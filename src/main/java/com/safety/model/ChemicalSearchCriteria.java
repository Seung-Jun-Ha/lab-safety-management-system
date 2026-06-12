package com.safety.model;

public class ChemicalSearchCriteria {

    private String labId;
    private String productId;

    public ChemicalSearchCriteria() {
    }

    public ChemicalSearchCriteria(String labId, String productId) {
        this.labId = labId;
        this.productId = productId;
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
}
