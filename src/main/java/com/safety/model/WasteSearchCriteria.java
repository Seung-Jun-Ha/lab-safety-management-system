package com.safety.model;

public class WasteSearchCriteria {

    private String labId;
    private String typeId;

    public WasteSearchCriteria() {
    }

    public WasteSearchCriteria(String labId, String typeId) {
        this.labId = labId;
        this.typeId = typeId;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
