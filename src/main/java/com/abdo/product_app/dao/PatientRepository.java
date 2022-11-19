package com.abdo.product_app.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.abdo.product_app.entities.Patient;

public interface PatientRepository  extends JpaRepository<Patient, Long>{
 public Page<Patient> findByNameContains(String mc,PageRequest pageable);
}
