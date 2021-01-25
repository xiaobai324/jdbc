package com.example.dproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class DprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DprojectApplication.class, args);
    }

}
