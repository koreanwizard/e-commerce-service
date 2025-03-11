package com.madebywizard.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		System.out.println("ECOMMERCE SERVICE HAS BEEN STARTED");
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
