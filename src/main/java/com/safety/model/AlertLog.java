package com.safety.model;

import java.time.LocalDateTime;

public class AlertLog {

    private String message;
    private String subSystem;
    private LocalDateTime createdAt;

    public AlertLog() {
    }

    public AlertLog(String message, String subSystem, LocalDateTime createdAt) {
        this.message = message;
        this.subSystem = subSystem;
        this.createdAt = createdAt;
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
