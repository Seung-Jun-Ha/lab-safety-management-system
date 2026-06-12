package com.safety.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRegisterDto {

    @NotBlank
    private String name;

    @NotBlank
    private String deptId;

    @Email
    @NotBlank
    private String email;

    public UserRegisterDto() {
    }

    public UserRegisterDto(String name, String deptId, String email) {
        this.name = name;
        this.deptId = deptId;
        this.email = email;
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
}
