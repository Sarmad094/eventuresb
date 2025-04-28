package com.example.eventuresb.DTO;

public class OrganizationDTO {
    private Long organizationId;
    private String name;
    private String email;
    private String field;
    private String description;

    // Konstruktører
    public OrganizationDTO() {
    }

    public OrganizationDTO(Long organizationId, String name, String email, String field, String description) {
        this.organizationId = organizationId;
        this.name = name;
        this.email = email;
        this.field = field;
        this.description = description;
    }

    // Getters and setters
    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}