package com.fintech.lite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@SpringBootApplication
public class FintechLiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(FintechLiteApplication.class, args);
    }
}

record Transaction(String id, double amount, String currency) {}

interface PaymentStrategy {
    void process(double amount);
}

@Component("creditCard")
class CreditCardPayment implements PaymentStrategy {
    public void process(double amount) { System.out.println("Processing Card: $" + amount); }
}

@Component("crypto")
class CryptoPayment implements PaymentStrategy {
    public void process(double amount) { System.out.println("Processing Crypto: " + amount + " BTC"); }
}

@Service
class PaymentService {
    private final Map<String, PaymentStrategy> strategies;
    public PaymentService(Map<String, PaymentStrategy> strategies) {
        this.strategies = strategies;
    }
    public void executePayment(String type, double amount) {
        PaymentStrategy strategy = strategies.getOrDefault(type, 
            amt -> { throw new IllegalArgumentException("Unsupported Type"); });
        strategy.process(amount);
    }
}

@RestController
@RequestMapping("/api/payments")
class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/{type}")
    public ResponseEntity<String> pay(@PathVariable String type, @RequestBody double amount) {
        paymentService.executePayment(type, amount);
        return ResponseEntity.ok("Payment Initiated via " + type);
    }
}
