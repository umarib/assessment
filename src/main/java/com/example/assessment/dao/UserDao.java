package com.example.assessment.dao;

import com.example.assessment.model.Affiliate;
import com.example.assessment.model.Customer;
import com.example.assessment.model.Employee;

public interface UserDao {
    Employee getEmployee();
    Affiliate getAffiliate();
    Customer getLongTermCustomer();
}