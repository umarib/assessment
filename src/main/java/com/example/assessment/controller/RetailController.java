package com.example.assessment.controller;

import com.example.assessment.dao.UserDao;
import com.example.assessment.model.User;
import com.example.assessment.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RetailController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DiscountService discountService;

    @GetMapping("/discount")
    public ResponseEntity<Double> getDiscount(@RequestParam("userId") String userId,
                                              @RequestParam("billAmount") double billAmount,
                                              @RequestParam("isGrocery") boolean isGrocery) {
        User user = switch (userId) {
            case "employee" -> userDao.getEmployee();
            case "affiliate" -> userDao.getAffiliate();
            default -> userDao.getLongTermCustomer();
        };

        double totalDiscount = 0;

        if (!isGrocery) {
            totalDiscount += discountService.calculateAmountBasedDiscount(billAmount);
            Double percentDiscount = discountService.getPercentageBasedDiscount(user, billAmount);

            if (percentDiscount != null) {
                totalDiscount += Math.min(totalDiscount, percentDiscount.doubleValue());
            }
        }

        return ResponseEntity.ok(totalDiscount);
    }
}