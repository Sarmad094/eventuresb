package com.example.eventuresb.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organizationid")
    private Long organizationID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    private String field;

    private String description;

    // Gettere og settere
    public Long getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(Long organizationID) {
        this.organizationID = organizationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
