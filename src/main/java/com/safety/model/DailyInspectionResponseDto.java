package com.safety.model;

import java.time.LocalDate;
import java.util.List;

public class DailyInspectionResponseDto {
    private Long id;
    private String labId;
    private LocalDate date;
    private String submittedBy;
    private String status;
    private List<InspectionItemDto> items;

    public DailyInspectionResponseDto(Long id, String labId, LocalDate date, String submittedBy, String status, List<InspectionItemDto> items) {
        this.id = id;
        this.labId = labId;
        this.date = date;
        this.submittedBy = submittedBy;
        this.status = status;
        this.items = items;
    }

    public Long getId() { return id; }
    public String getLabId() { return labId; }
    public LocalDate getDate() { return date; }
    public String getSubmittedBy() { return submittedBy; }
    public String getStatus() { return status; }
    public List<InspectionItemDto> getItems() { return items; }
}