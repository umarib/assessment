package com.example.assessment.controller;

import com.example.assessment.dao.UserDao;
import com.example.assessment.model.User;
import com.example.assessment.service.DiscountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RetailController {

    Logger logger = LoggerFactory.getLogger(RetailController.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private DiscountService discountService;

    @GetMapping("/discount")
    public ResponseEntity<Double> getDiscount(@RequestParam("userId") long userId,
                                              @RequestParam("billAmount") double billAmount,
                                              @RequestParam("isGrocery") boolean isGrocery) {

        Optional<User> userOpt = userDao.getUser(userId);

        if (userOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOpt.get();

        logger.debug("billAmount = {} , isGrocery = {} , userid = {} , user.getUserRole() = {}",billAmount,isGrocery,userId,user.getUserRole());


        double totalDiscount = 0.0;
        if (!isGrocery) {
            Double percentDiscount = discountService.getPercentageBasedDiscount(user, billAmount);
            logger.debug("percentDiscount User type {} ",percentDiscount);
            totalDiscount += percentDiscount;

        }
        double hundredBillTypeDiscount = discountService.calculateAmountBasedDiscount(billAmount);
        logger.debug("100 discount type {} ",hundredBillTypeDiscount);
        totalDiscount += hundredBillTypeDiscount;
        logger.debug("totalDiscount {} ",totalDiscount);
        return ResponseEntity.ok(totalDiscount);
    }
}
