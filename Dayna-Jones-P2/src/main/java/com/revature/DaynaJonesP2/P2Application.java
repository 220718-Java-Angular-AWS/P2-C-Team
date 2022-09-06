package com.revature.DaynaJonesP2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SpringBootApplication (ScanBasePackages = "com.revature.DaynaJonesP2.beans")
    public class P2Application {
        public static void main(String[] args) {
            SpringApplication.run(P2Application.class, args);
        }
    }