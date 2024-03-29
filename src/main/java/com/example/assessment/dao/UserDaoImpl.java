package com.example.assessment.dao;

import com.example.assessment.model.Affiliate;
import com.example.assessment.model.Customer;
import com.example.assessment.model.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@Primary
public class UserDaoImpl implements UserDao {
    @Override
    public Employee getEmployee() {
        return new Employee();
    }

    @Override
    public Affiliate getAffiliate() {
        return new Affiliate();
    }

    @Override
    public Customer getLongTermCustomer() {
        var customer = new Customer();
        customer.setRegistrationDate(LocalDate.of(2018, 1, 1));
        return customer;
    }
}