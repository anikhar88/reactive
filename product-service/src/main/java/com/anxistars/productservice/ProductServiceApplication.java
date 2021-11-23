package com.anxistars.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {
// start docker mongo & expressing using > "docker-compose up" command
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
