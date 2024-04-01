package com.example.assessment.model;

import com.example.assessment.util.UserTypes;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public abstract class User {
    private Long id;
    private String fullName;
    private ZonedDateTime dateOfJoining;

    private UserTypes userRole;

    protected User(Long id, String fullName, ZonedDateTime dateOfJoining, UserTypes userRole) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfJoining = dateOfJoining;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(ZonedDateTime dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserTypes getUserRole() {
        return this.userRole;
    }

    public void setUserRole(UserTypes userRole) {
        this.userRole = userRole;
    }

    public long getRelationShipYears() {
        return ChronoUnit.YEARS.between(this.getDateOfJoining(), ZonedDateTime.now());
    }
}