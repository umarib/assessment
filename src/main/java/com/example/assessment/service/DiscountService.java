package com.example.assessment.service;

import com.example.assessment.dao.UserDao;
import com.example.assessment.model.Customer;
import com.example.assessment.model.User;
import com.example.assessment.util.UserTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    @Autowired
    private UserDao userDao;

    public double calculateAmountBasedDiscount(double amount) {
        int numberOfHundredDollarsUnits = (int)(amount / 100);
        return (double) numberOfHundredDollarsUnits * 5;
    }


    public Double getPercentageBasedDiscount(User user, double amount) {
        if (user.getUserRole() == UserTypes.EMPLOYEE) {
            return 0.3 * amount;
        } else if (user.getUserRole() == UserTypes.AFFILIATE) {
            return 0.1 * amount;
        } else if (user.getUserRole() == UserTypes.CUSTOMER && ((Customer)user).isLongTermCustomer()) {
            return 0.05 * amount;
        }
        return 0.0;
    }
}