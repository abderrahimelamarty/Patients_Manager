package com.abdo.product_app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.CommandLinePropertySource;

import com.abdo.product_app.dao.PatientRepository;
import com.abdo.product_app.entities.Patient;

@SpringBootApplication
public class ProductAppApplication{
	

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}

	
}
