package com.safety.model;

import java.time.LocalDateTime;

public class UserRegistrationRequest {

    private String requestId;
    private String name;
    private String deptId;
    private String email;
    private String status;
    private LocalDateTime requestedAt;

    public UserRegistrationRequest() {
    }

    public UserRegistrationRequest(String requestId, String name, String deptId, String email, String status, LocalDateTime requestedAt) {
        this.requestId = requestId;
        this.name = name;
        this.deptId = deptId;
        this.email = email;
        this.status = status;
        this.requestedAt = requestedAt;
    }

    public static UserRegistrationRequest pending(UserRegisterDto dto) {
        return new UserRegistrationRequest(null, dto.getName(), dto.getDeptId(), dto.getEmail(), "PENDING", LocalDateTime.now());
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }
}
