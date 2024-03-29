package com.example.assessment.service;

import com.example.assessment.model.Affiliate;
import com.example.assessment.model.Customer;
import com.example.assessment.model.Employee;
import com.example.assessment.model.User;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public double calculateAmountBasedDiscount(double amount) {
        if (amount >= 100 && amount < 200) {
            return 5;
        } else if (amount >= 200 && amount < 300) {
            return 10;
        } else if (amount >= 300) {
            return 15;
        }
        return 0;
    }

    public Double getPercentageBasedDiscount(User user, double amount) {
        if (user instanceof Employee) {
            return 0.3 * amount;
        } else if (user instanceof Affiliate) {
            return 0.1 * amount;
        } else if (user instanceof Customer) {
            return 0.05 * amount;
        }
        return null;
    }
}