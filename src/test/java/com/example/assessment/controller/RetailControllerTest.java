package com.example.assessment.controller;

import com.example.assessment.dao.UserDao;
import com.example.assessment.model.User;
import com.example.assessment.persistence.DummyDataGenerator;
import com.example.assessment.service.DiscountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class RetailControllerTest {

    @Mock
    private UserDao userDao;

    @Mock
    private DiscountService discountService;

    @InjectMocks
    private RetailController retailController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("New Customer With the Grocery")
    public void testNewCustomerWithGrocery() throws Exception {
        final long USER_ID = 10L;
        final double BILL_AMOUNT = 100.00;
        final boolean IS_GROCERY = true;
        User user = DummyDataGenerator.getDummyCustomer(10l);
        Mockito.when(userDao.getUser(USER_ID)).thenReturn(Optional.of(user));
        Mockito.lenient().when(discountService.getPercentageBasedDiscount(user, BILL_AMOUNT)).thenReturn(0.0);
        Mockito.when(discountService.calculateAmountBasedDiscount(BILL_AMOUNT)).thenReturn(5.0);
        final ResponseEntity<?> response = retailController.getDiscount(USER_ID, BILL_AMOUNT, IS_GROCERY);
        assertEquals(5.0,response.getBody());
    }

    @Test
    @DisplayName("New Customer Without the Grocery")
    public void testNewCustomerWithOutGrocery() throws Exception {
        final long USER_ID = 10L;
        final double BILL_AMOUNT = 100.00;
        final boolean IS_GROCERY = false;
        User user = DummyDataGenerator.getDummyCustomer(10l);
        Mockito.when(userDao.getUser(USER_ID)).thenReturn(Optional.of(user));
        Mockito.when(discountService.calculateAmountBasedDiscount(BILL_AMOUNT)).thenReturn(5.0);
        final ResponseEntity<?> response = retailController.getDiscount(USER_ID, BILL_AMOUNT, IS_GROCERY);
        assertEquals(5.0,response.getBody());
    }

    @Test
    @DisplayName("LongTerm Customer Without the Grocery")
    public void testLongTermCustomerWithOutGrocery() throws Exception {
        final long USER_ID = 11L;
        final double BILL_AMOUNT = 100.00;
        final boolean IS_GROCERY = false;
        User user = DummyDataGenerator.getDummyCustomer(11l);
        Mockito.when(userDao.getUser(USER_ID)).thenReturn(Optional.of(user));
        Mockito.lenient().when(discountService.getPercentageBasedDiscount(user, BILL_AMOUNT)).thenReturn(5.0);
        Mockito.when(discountService.calculateAmountBasedDiscount(BILL_AMOUNT)).thenReturn(5.0);
        final ResponseEntity<?> response = retailController.getDiscount(USER_ID, BILL_AMOUNT, IS_GROCERY);
        assertEquals(10.0,response.getBody());
    }

    @Test
    @DisplayName("Employee Without the Grocery")
    public void testEmployeeWithOutGrocery() throws Exception {
        final long USER_ID = 1L;
        final double BILL_AMOUNT = 100.00;
        final boolean IS_GROCERY = false;
        User user = DummyDataGenerator.getDummyEmployee(1l);
        Mockito.when(userDao.getUser(USER_ID)).thenReturn(Optional.of(user));
        Mockito.lenient().when(discountService.getPercentageBasedDiscount(user, BILL_AMOUNT)).thenReturn(30.0);
        Mockito.when(discountService.calculateAmountBasedDiscount(BILL_AMOUNT)).thenReturn(5.0);
        final ResponseEntity<?> response = retailController.getDiscount(USER_ID, BILL_AMOUNT, IS_GROCERY);
        assertEquals(35.0,response.getBody());
    }

    @Test
    @DisplayName("Employee With the Grocery")
    public void testEmployeeWithGrocery() throws Exception {
        final long USER_ID = 1L;
        final double BILL_AMOUNT = 100.00;
        final boolean IS_GROCERY = true;
        User user = DummyDataGenerator.getDummyEmployee(1l);
        Mockito.when(userDao.getUser(USER_ID)).thenReturn(Optional.of(user));
        Mockito.lenient().when(discountService.getPercentageBasedDiscount(user, BILL_AMOUNT)).thenReturn(0.0);
        Mockito.when(discountService.calculateAmountBasedDiscount(BILL_AMOUNT)).thenReturn(5.0);
        final ResponseEntity<?> response = retailController.getDiscount(USER_ID, BILL_AMOUNT, IS_GROCERY);
        assertEquals(5.0,response.getBody());
    }

    @Test
    @DisplayName("Affiliate Without the Grocery")
    public void testAffiliateWithOutGrocery() throws Exception {
        final long USER_ID = 5L;
        final double BILL_AMOUNT = 100.00;
        final boolean IS_GROCERY = false;
        User user = DummyDataGenerator.getDummyAffiliate(5l);
        Mockito.when(userDao.getUser(USER_ID)).thenReturn(Optional.of(user));
        Mockito.lenient().when(discountService.getPercentageBasedDiscount(user, BILL_AMOUNT)).thenReturn(10.0);
        Mockito.when(discountService.calculateAmountBasedDiscount(BILL_AMOUNT)).thenReturn(5.0);
        final ResponseEntity<?> response = retailController.getDiscount(USER_ID, BILL_AMOUNT, IS_GROCERY);
        assertEquals(15.0,response.getBody());
    }

    @Test
    @DisplayName("Affiliate With the Grocery")
    public void testAffiliateWithGrocery() throws Exception {
        final long USER_ID = 5L;
        final double BILL_AMOUNT = 100.00;
        final boolean IS_GROCERY = true;
        User user = DummyDataGenerator.getDummyAffiliate(5l);
        Mockito.when(userDao.getUser(USER_ID)).thenReturn(Optional.of(user));
        Mockito.lenient().when(discountService.getPercentageBasedDiscount(user, BILL_AMOUNT)).thenReturn(0.0);
        Mockito.when(discountService.calculateAmountBasedDiscount(BILL_AMOUNT)).thenReturn(5.0);
        final ResponseEntity<?> response = retailController.getDiscount(USER_ID, BILL_AMOUNT, IS_GROCERY);
        assertEquals(5.0,response.getBody());
    }


}