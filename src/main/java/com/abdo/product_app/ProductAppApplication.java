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
public class ProductAppApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientrepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientrepo.save(new Patient(1,"abdo",new Date(),false));
		patientrepo.save(new Patient(2,"anas",new Date(),false));
		patientrepo.save(new Patient(4,"omar",new Date(),false));


		patientrepo.findAll().forEach(p->{
			System.out.println(p.getName());
		});
		
	}

}
