package com.revarute.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.revarute.marketplace.beans")
public class MarketPlaceGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketPlaceGameApplication.class, args);
	}

}
