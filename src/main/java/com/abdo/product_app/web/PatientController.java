package com.abdo.product_app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List ;
import com.abdo.product_app.dao.PatientRepository;
import com.abdo.product_app.entities.Patient;

@Controller
public class PatientController {
	@Autowired
	private PatientRepository patientrepo;
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	@GetMapping("/patients")
	public String List(Model model) {
	List<Patient> patients=patientrepo.findAll();
     model.addAttribute("patients", patients);
		return "patients";
	}

}
