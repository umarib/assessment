package com.example.assessment.model;


import com.example.assessment.util.UserTypes;

import java.time.ZonedDateTime;

public class Affiliate extends User {

    private double saleBasePercentage = 0.0;
    public Affiliate(Long id, String fullName, ZonedDateTime dateOfJoining) {
        super(id, fullName, dateOfJoining, UserTypes.AFFILIATE);
    }

    public double getSaleBasePercentage() {
        return saleBasePercentage;
    }

    public void setSaleBasePercentage(double saleBasePercentage) {
        this.saleBasePercentage = saleBasePercentage;
    }

}