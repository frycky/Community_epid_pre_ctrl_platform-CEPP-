package com.agentp.cepp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CeppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CeppApplication.class, args);
    }

}
