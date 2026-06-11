package com.safety.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class DailyInspectionRegisterDto {
    @NotBlank(message = "연구실 ID는 필수입니다.")
    private String labId;

    @NotNull(message = "점검 일자는 필수입니다.")
    private LocalDate date;

    @NotBlank(message = "제출자는 필수 항목입니다.")
    private String submittedBy;

    @NotBlank(message = "상태는 필수 항목입니다.")
    private String status;

    @NotEmpty(message = "점검 상세 내역 항목이 비어있습니다.")
    @Valid
    private List<InspectionItemDto> items;

    // Getters and Setters
    public String getLabId() { return labId; }
    public void setLabId(String labId) { this.labId = labId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<InspectionItemDto> getItems() { return items; }
    public void setItems(List<InspectionItemDto> items) { this.items = items; }
}