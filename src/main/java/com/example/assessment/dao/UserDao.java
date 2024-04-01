package com.example.assessment.dao;

import com.example.assessment.model.Affiliate;
import com.example.assessment.model.Customer;
import com.example.assessment.model.Employee;
import com.example.assessment.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> getUser(long id);
    Optional<Employee> getEmployee(long id);
    Optional<Affiliate> getAffiliate(long id);
    List<Customer> getLongTermCustomers();
    List<Employee> getAllEmployees();
    List<Affiliate> getAllAffiliates();
    List<Customer> getAllCustomers();

}