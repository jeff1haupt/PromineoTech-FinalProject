package com.finalproject.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.finalproject.finalproject")
@SpringBootApplication(scanBasePackages = {"com.finalproject.finalproject"})
public class FinalprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalprojectApplication.class, args);
    }

}
