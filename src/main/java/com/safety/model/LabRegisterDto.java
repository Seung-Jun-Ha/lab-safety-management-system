package com.safety.model;

public class LabRegisterDto {

	private String labName;
	private String buildingId;
	private Integer floor;
	private String type;
	private Boolean inspectionTarget;

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

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getInspectionTarget() {
		return inspectionTarget;
	}

	public void setInspectionTarget(Boolean inspectionTarget) {
		this.inspectionTarget = inspectionTarget;
	}
}
