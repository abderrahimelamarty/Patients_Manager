package com.abdo.product_app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List ;

import javax.validation.Valid;

import com.abdo.product_app.dao.PatientRepository;
import com.abdo.product_app.entities.Patient;

@Controller
public class PatientController {
	@Autowired
	private PatientRepository patientrepo;
	@GetMapping(path="/index")
	public String index() {
		return "index";
	}
	@GetMapping(path="/patients")
	public String list(Model model, @RequestParam(name="page", defaultValue ="0") int page, @RequestParam(name="size", defaultValue ="5") int size,@RequestParam(name="keyword", defaultValue ="") String mc) {
	Page<Patient> Pagepatients=patientrepo.findByNameContains(mc, PageRequest.of(page, size));
     model.addAttribute("patients", Pagepatients.getContent());
     model.addAttribute("pages", new int[Pagepatients.getTotalPages()]);
     model.addAttribute("currentPage",page);
     model.addAttribute("keyword", mc);
     model.addAttribute("size", size);
		return "patients";
	}
	@GetMapping(path="/deletePatient")
	public String deletePatient(Long id,String keyword,int page,int size,Model model) {
		patientrepo.deleteById(id);
		return "redirect:/patients?page="+page+"&size="+size+"&keyword="+keyword;
	}
	@GetMapping(path="/deletePatient2")
	public String deletePatient2(Long id,String keyword,int page,int size,Model model) {
		patientrepo.deleteById(id);
		return list(model,page,size,keyword);
	}
	@GetMapping("/formPatient")
	public String formPatient(Model model ) {
		model.addAttribute("patient", new Patient());
		return "formPatient";
	}
	@PostMapping("/savePatient")
	public String savePatient(@Valid Patient patient, BindingResult bindingresult) {
		if(bindingresult.hasErrors()) return "formPatient";
		patientrepo.save(patient);
		return "formPatient";
	}
	@GetMapping("/editPatient")
	public String editPatient(Model model,Long id ) {
	Patient p= patientrepo.findById(id).get();
	model.addAttribute("patient", p);
		return "formPatient";
	}
	@GetMapping("/listPatients")
	@ResponseBody
	public List<Patient> listPatients(){
		return patientrepo.findAll();
	}
}
