package com.abdo.product_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdo.product_app.entities.Patient;

public interface PatientRepository  extends JpaRepository<Patient, Long>{

}
