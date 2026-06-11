package com.safety.model;

public class User {

    private String userId;
    private String name;
    private String deptId;
    private String email;
    private String role;
    private String status;

    public User() {
    }

    public User(String userId, String name, String deptId, String email, String role, String status) {
        this.userId = userId;
        this.name = name;
        this.deptId = deptId;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public static User pendingFrom(UserRegisterDto dto) {
        return new User(null, dto.getName(), dto.getDeptId(), dto.getEmail(), "USER", "PENDING");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
