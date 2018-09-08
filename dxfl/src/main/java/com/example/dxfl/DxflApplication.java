package com.example.dxfl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(order = 10)
public class DxflApplication {

    public static void main(String[] args) {
        SpringApplication.run(DxflApplication.class, args);
    }
}
