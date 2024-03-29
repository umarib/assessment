package com.example.assessment.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Customer extends User {
    private LocalDate registrationDate;

    public Customer() {
        super();
        this.registrationDate = LocalDate.now();
    }

    public long numberOfYearsAsCustomer() {
        return ChronoUnit.YEARS.between(this.registrationDate, LocalDate.now());
    }

    public boolean isLongTermCustomer() {
        return numberOfYearsAsCustomer() > 2;
    }
}