package com.safety.model;

import java.time.LocalDate;

public class DailyInspectionSummaryDto {
    private Long id;
    private String labId;
    private LocalDate date;
    private String submittedBy;
    private String status;
    private int itemCount;

    public DailyInspectionSummaryDto(Long id, String labId, LocalDate date, String submittedBy, String status, int itemCount) {
        this.id = id;
        this.labId = labId;
        this.date = date;
        this.submittedBy = submittedBy;
        this.status = status;
        this.itemCount = itemCount;
    }

    public Long getId() { return id; }
    public String getLabId() { return labId; }
    public LocalDate getDate() { return date; }
    public String getSubmittedBy() { return submittedBy; }
    public String getStatus() { return status; }
    public int getItemCount() { return itemCount; }
}