package com.example.assessment.persistence;

import com.example.assessment.model.Affiliate;
import com.example.assessment.model.Customer;
import com.example.assessment.model.Employee;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class DummyDataGenerator {


    private DummyDataGenerator() {

    }
    public static Employee getDummyEmployee(Long id) {
        return new Employee((long) id, "Employee" + id, ZonedDateTime.now());
    }

    public static Affiliate getDummyAffiliate(Long id) {
        return new Affiliate((long) id, "Affiliate" + id, ZonedDateTime.now());
    }

    public static Customer getDummyCustomer(Long id) {
        return new Customer((long)id, "Customer" + id, ZonedDateTime.now(),"Silver");
    }

    public static Customer getDummyLongTermCustomer(Long id) {
        Duration twoYearsAgo = Duration.ofDays(-370L*2);
        return new Customer((long)id, "Customer" + id, ZonedDateTime.now().plus(twoYearsAgo),"Gold");
    }

    public static List<Employee> getDummyEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee employee = getDummyEmployee((long) i);
            employeeList.add(employee);
        }
        return employeeList;
    }

    public static List<Affiliate> getDummyAffiliateList() {
        List<Affiliate> affiliateList = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            Affiliate affiliate = getDummyAffiliate((long) i);
            affiliate.setSaleBasePercentage(10.0);
            affiliateList.add(affiliate);
        }
        return affiliateList;
    }

    public static List<Customer> getDummyCustomerList() {
        List<Customer> customerList = new ArrayList<>();

        // Simple customer
        Customer customer1 = getDummyCustomer((long)10);
        customerList.add(customer1);

        // Long term customer
        Customer customer2 = getDummyLongTermCustomer((long)11);
        customerList.add(customer2);

        return customerList;
    }


}
