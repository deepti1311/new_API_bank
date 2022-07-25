package io.tntra.api_bank;

import io.tntra.api_bank.Enum.pkg.AccountType;
import io.tntra.api_bank.services.BankAccount;
import io.tntra.api_bank.Exceptions.minimumbalanceException;
import io.tntra.api_bank.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@SpringBootApplication
@RestController
public class ApiBankApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiBankApplication.class, args);
    }

//    public class bank_Controller{
//
//        System.out.println('\n');
@GetMapping("/bank")
public String BANK(){
    HDFC_Bank acc1 = null;
    try {
        acc1 = new HDFC_Bank("Deepti", BigDecimal.valueOf(10000), BigDecimal.valueOf(3000), AccountType.SAVINGS);
    } catch (minimumbalanceException e) {
        throw new RuntimeException(e);
    }
    acc1.Deposite(BigDecimal.valueOf(1000));
//    acc1.Widthdraw(BigDecimal.valueOf(5000));

    System.out.println('\n');

        return "\n\n\nAmount Deposited Succesfully!!!";
    }

    }


