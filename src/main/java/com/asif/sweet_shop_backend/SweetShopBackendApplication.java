package com.asif.sweet_shop_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.autoconfigure.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class SweetShopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SweetShopBackendApplication.class, args);
	}

}
