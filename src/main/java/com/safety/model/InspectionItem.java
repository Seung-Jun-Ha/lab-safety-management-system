package com.safety.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inspection_items")
public class InspectionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "daily_inspection_id", nullable = false)
    private DailyInspection dailyInspection;

    @Column(nullable = false)
    private String checkItem;

    @Column(nullable = false)
    private String result;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public DailyInspection getDailyInspection() { return dailyInspection; }
    public void setDailyInspection(DailyInspection dailyInspection) { this.dailyInspection = dailyInspection; }
    public String getCheckItem() { return checkItem; }
    public void setCheckItem(String checkItem) { this.checkItem = checkItem; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}