package com.safety.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "labs")
public class Lab {

	@Id
	@Column(name = "lab_id", nullable = false, updatable = false)
	private String labId;

	@Column(nullable = false)
	private String labName;

	private String buildingId;

	private int floor;

	private String type;

	private boolean inspectionTarget;

	public String getLabId() {
		return labId;
	}

	public void setLabId(String labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isInspectionTarget() {
		return inspectionTarget;
	}

	public void setInspectionTarget(boolean inspectionTarget) {
		this.inspectionTarget = inspectionTarget;
	}
}
