package com.example.assessment.model;

import com.example.assessment.util.UserTypes;

import java.time.ZonedDateTime;


public class Customer extends User {

    private String customerMemberShipType;

    public Customer(Long id, String fullName, ZonedDateTime dateOfJoining, String customerMemberShipType) {
        super(id, fullName, dateOfJoining, UserTypes.CUSTOMER);
        this.customerMemberShipType = customerMemberShipType;
    }

    public String getCustomerMemberShipType() {
        return customerMemberShipType;
    }

    public void setCustomerMemberShipType(String customerMemberShipType) {
        this.customerMemberShipType = customerMemberShipType;
    }

    public boolean isLongTermCustomer() {
        return getRelationShipYears() >= 2;
    }
}