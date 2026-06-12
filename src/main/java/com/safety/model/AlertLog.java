package com.safety.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alert_logs")
public class AlertLog {

	@Id
	@Column(name = "log_id", nullable = false, updatable = false)
	private String logId;

	@Column(nullable = false)
	private String message;

	@Column(nullable = false)
	private String subSystem;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	public AlertLog() {
	}

	public AlertLog(String message, String subSystem, LocalDateTime createdAt) {
		this.message = message;
		this.subSystem = subSystem;
		this.createdAt = createdAt;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
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
