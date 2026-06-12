package com.safety.model;

public class ChemicalProduct {

    private String productId;
    private String productName;
    private String casNo;
    private String hazardCategory;

    public ChemicalProduct() {
    }

    public ChemicalProduct(String productId, String productName, String casNo, String hazardCategory) {
        this.productId = productId;
        this.productName = productName;
        this.casNo = casNo;
        this.hazardCategory = hazardCategory;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCasNo() {
        return casNo;
    }

    public void setCasNo(String casNo) {
        this.casNo = casNo;
    }

    public String getHazardCategory() {
        return hazardCategory;
    }

    public void setHazardCategory(String hazardCategory) {
        this.hazardCategory = hazardCategory;
    }
}
