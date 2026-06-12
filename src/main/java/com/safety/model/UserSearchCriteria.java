package com.safety.model;

public class UserSearchCriteria {

    private String name;
    private String role;

    public UserSearchCriteria() {
    }

    public UserSearchCriteria(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
