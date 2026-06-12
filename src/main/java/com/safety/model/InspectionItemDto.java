package com.safety.model;

import jakarta.validation.constraints.NotBlank;

public class InspectionItemDto {
    @NotBlank(message = "점검 항목명은 필수입니다.")
    private String checkItem;

    @NotBlank(message = "점검 결과는 필수입니다.")
    private String result;

    // Getters and Setters
    public String getCheckItem() { return checkItem; }
    public void setCheckItem(String checkItem) { this.checkItem = checkItem; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}