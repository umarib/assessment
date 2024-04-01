package com.example.assessment.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.assessment.AssessmentApplication;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AssessmentApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RetailControllerIntegrationTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testEmployeeDiscountWithGrocery() {

        long userId = 1l;
        double billAmount = 100.0;
        boolean isGrocery = true;

        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/discount?userId="+userId+"&billAmount="+billAmount+"&isGrocery="+isGrocery),
                HttpMethod.GET, entity, String.class);
        String expected = "5.0";
        assertEquals(expected, response.getBody());
    }

    @Test
    public void testEmployeeDiscountWithOutGrocery(){

        long userId = 1l;
        double billAmount = 100.0;
        boolean isGrocery = false;

        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/discount?userId="+userId+"&billAmount="+billAmount+"&isGrocery="+isGrocery),
                HttpMethod.GET, entity, String.class);
        String expected = "35.0";
        assertEquals(expected, response.getBody());
    }

    @Test
    public void testAffiliateDiscountWithGrocery(){

        long userId = 5l;
        double billAmount = 100.0;
        boolean isGrocery = true;

        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/discount?userId="+userId+"&billAmount="+billAmount+"&isGrocery="+isGrocery),
                HttpMethod.GET, entity, String.class);
        String expected = "5.0";
        assertEquals(expected, response.getBody());
    }

    @Test
    public void testAffiliateDiscountWithoutGrocery(){

        long userId = 5l;
        double billAmount = 100.0;
        boolean isGrocery = false;

        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/discount?userId="+userId+"&billAmount="+billAmount+"&isGrocery="+isGrocery),
                HttpMethod.GET, entity, String.class);
        String expected = "15.0";
        assertEquals(expected, response.getBody());
    }

    @Test
    public void testNewCustomerDiscountWithoutGrocery(){

        long userId = 10l;
        double billAmount = 100.0;
        boolean isGrocery = false;

        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/discount?userId="+userId+"&billAmount="+billAmount+"&isGrocery="+isGrocery),
                HttpMethod.GET, entity, String.class);
        String expected = "5.0";
        assertEquals(expected, response.getBody());
    }

    @Test
    public void testNewCustomerDiscountWithGrocery(){

        long userId = 10l;
        double billAmount = 100.0;
        boolean isGrocery = true;

        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/discount?userId="+userId+"&billAmount="+billAmount+"&isGrocery="+isGrocery),
                HttpMethod.GET, entity, String.class);
        String expected = "5.0";
        assertEquals(expected, response.getBody());
    }

    @Test
    public void testLongTermCustomerDiscountWithGrocery(){

        long userId = 11l;
        double billAmount = 100.0;
        boolean isGrocery = true;

        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/discount?userId="+userId+"&billAmount="+billAmount+"&isGrocery="+isGrocery),
                HttpMethod.GET, entity, String.class);
        String expected = "5.0";
        assertEquals(expected, response.getBody());
    }

    @Test
    public void testLongTermCustomerDiscountWithoutGrocery(){

        long userId = 11l;
        double billAmount = 100.0;
        boolean isGrocery = false;

        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/discount?userId="+userId+"&billAmount="+billAmount+"&isGrocery="+isGrocery),
                HttpMethod.GET, entity, String.class);
        String expected = "10.0";
        assertEquals(expected, response.getBody());
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
