package com.safety.model;

public class UserResponseDto {

    private String userId;
    private String name;
    private String deptId;
    private String email;
    private String role;
    private String status;

    public UserResponseDto() {
    }

    public UserResponseDto(String userId, String name, String deptId, String email, String role, String status) {
        this.userId = userId;
        this.name = name;
        this.deptId = deptId;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public static UserResponseDto from(User user) {
        return new UserResponseDto(
                user.getUserId(),
                user.getName(),
                user.getDeptId(),
                user.getEmail(),
                user.getRole(),
                user.getStatus()
        );
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
