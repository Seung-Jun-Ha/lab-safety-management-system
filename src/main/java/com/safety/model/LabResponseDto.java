package com.safety.model;

public class LabResponseDto {

	private String labId;
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
