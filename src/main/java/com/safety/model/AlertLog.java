package com.safety.model;

import java.time.LocalDateTime;

public class AlertLog {

    private Long logId;
    private String message;
    private String subSystem;
    private LocalDateTime createdAt;

    public AlertLog() {
    }

    public AlertLog(Long logId, String message, String subSystem) {
        this.logId = logId;
        this.message = message;
        this.subSystem = subSystem;
        this.createdAt = LocalDateTime.now();
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubSystem() {
        return subSystem;
    }

    public void setSubSystem(String subSystem) {
        this.subSystem = subSystem;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
