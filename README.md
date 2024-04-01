# Retail Store Discount System

This repository contains source code for a simple Java 17 Spring Boot application that implements a retail store discount system according to specified rules.

## Table of Contents
1. [Project Structure](#project-structure)
2. [Functionality Overview](#functionality-overview)
    1. [Fixed Amount Based Discounts](#fixed-amount-based-discounts)
    2. [Percentage Based Discounts](#percentage-based-discounts)
        1. [Regular Employee Discount](#regular-employee-discount)
        2. [Affiliate Partner Discount](#affiliate-partner-discount)
        3. [Long Term Client Discount](#long-term-client-discount)
    3. [Additional Information](#additional-information)
3. [Running Locally](#running-locally)
4. [Unit Tests](#unit-tests)
5. [Contribution Guidelines](#contribution-guidelines)

## Project Structure

* **[com.retailstore.controller](./src/main/java/com/retailstore/controller)** – Contains RESTful API endpoint definitions written in RetailController.
* **[com.retailstore.dao](./src/main/java/com/retailstore/dao)** – Defines Data Access Object interfaces used for retrieving mock users.
* **[com.retailstore.model](./src/main/java/com/retailstore/model)** – Holds model classes representing employees, affiliates, customers and order details.
* **[com.retailstore.service](./src/main/java/com/retailstore/service)** – Implements business logic related to calculating various kinds of discounts within DiscountService.

## Functionality Overview

### Fixed Amount Based Discounts

| Spending Range | Reduction          |
|----------------|--------------------|
| Less than $100 | No reduction      |
| $100-$200       | Receive $5 off     |
| $200-$300       | Receive $10 off    |
| Greater than or equal to $300 | Receive $15 off |

### Percentage Based Discounts

#### Regular Employee Discount
- Applies to all purchases regardless of category.
- Provides a flat 30% deduction.

#### Affiliate Partner Discount
- Extends exclusively to partners registered in the company's affiliate program.
- Offers a consistent 10% cut across product lines excluding groceries.

#### Long Term Client Discount
- Bestowed upon clients having patronized the establishment beyond two consecutive fiscal years.
- Grants a steady 5% rebate irrespective of merchandise classification.

### Additional Information
- Grocery items don't qualify for extra discounts other than those outlined previously.
- Amongst the three potential percentage-based deductions, merely one can be implemented against a single transaction. Specifically, when both normal staff standing and veteran consumer qualifications coincide, preference shall always go towards assessing the employee initially.

## CURL
curl --location --request GET 'http://localhost:8080/api/discount?userId=5&billAmount=100.0&isGrocery=true' \
--header 'Content-Type: application/json' \
--data '{

    "sourceDIR":"Explain method getEmployeeThatNeedsRetirementBenefits",
    "destinationDIR":2000
}'