package com.example.assessment.model;


import com.example.assessment.util.UserTypes;

import java.time.ZonedDateTime;

public class Employee extends User {

    private String designation;

    public Employee(Long id, String fullName, ZonedDateTime dateOfJoining) {
        super(id, fullName, dateOfJoining, UserTypes.EMPLOYEE);
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


}
