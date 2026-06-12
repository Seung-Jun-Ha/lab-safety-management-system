package com.safety.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "daily_inspections")
public class DailyInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String labId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String submittedBy;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "dailyInspection", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InspectionItem> items = new ArrayList<>();

    public void addItem(InspectionItem item) {
        this.items.add(item);
        item.setDailyInspection(this);
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLabId() { return labId; }
    public void setLabId(String labId) { this.labId = labId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<InspectionItem> getItems() { return items; }
    public void setItems(List<InspectionItem> items) { this.items = items; }
}