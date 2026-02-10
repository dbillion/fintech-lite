package com.fintech.lite;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class FintechLiteApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
        assertNotNull(applicationContext, "The application context should have loaded.");
	}

    @Test
    void paymentStrategiesArePresent() {
        assertNotNull(applicationContext.getBean("creditCard"), "CreditCardPayment strategy should be a bean.");
        assertNotNull(applicationContext.getBean("crypto"), "CryptoPayment strategy should be a bean.");
    }
}
