package com.example.assessment.service;

import com.example.assessment.persistence.DummyDataGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DiscountServiceTest {

    @InjectMocks
    private DiscountService service;

    @Test
    void testCalculateAmountBasedDiscount() {
        assertEquals(5.0, service.calculateAmountBasedDiscount(100.0));
    }

    @Test
    void testGetPercentageBasedDiscount() {
        assertEquals(30.0, service.getPercentageBasedDiscount(DummyDataGenerator.getDummyEmployee(1l), 100.0));
    }

    @Test
    void testGetPercentageBasedDiscountForEmployee() {
        assertEquals(30.0, service.getPercentageBasedDiscount(DummyDataGenerator.getDummyEmployee(1l), 100.0));
    }
    @Test
    void testGetPercentageBasedDiscountForAffiliate() {
        assertEquals(10.0, service.getPercentageBasedDiscount(DummyDataGenerator.getDummyAffiliate(5l), 100.0));
    }
    @Test
    void testGetPercentageBasedDiscountForNewCustomer() {
        assertEquals(0.0, service.getPercentageBasedDiscount(DummyDataGenerator.getDummyCustomer(10l), 100.0));
    }
    @Test
    void testGetPercentageBasedDiscountForLongTermCustomer() {
        assertEquals(5.0, service.getPercentageBasedDiscount(DummyDataGenerator.getDummyLongTermCustomer(11l), 100.0));
    }
}