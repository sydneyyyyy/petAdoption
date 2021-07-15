package com.revature.controllers;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Application;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.Pet;
import com.revature.repos.EmployeeHibernate;
import com.revature.repos.PetRepo;
import com.revature.services.ApplicationServicesImpl;
import com.revature.services.CustomerServicesImpl;
import com.revature.services.EmployeeServicesImpl;
import com.revature.services.PetServicesImpl;

@RestController
@RequestMapping("/applications")
@CrossOrigin(origins = "http://localhost:8080")
public class ApplicationController {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	

	private ApplicationServicesImpl as;	
	private EmployeeServicesImpl es;
	private CustomerServicesImpl cs;
	private PetServicesImpl ps;

	//public Gson gson = new Gson();
	@Autowired
	public ApplicationController(ApplicationServicesImpl appServ, EmployeeServicesImpl es, PetServicesImpl ps,CustomerServicesImpl cs ) {
		this.as = appServ;
		this.es = es;
		this.ps = ps;
		this.cs = cs;
	}
	
	//@GetMapping()
	//public ResponseEntity<List<Pet>> getAllPets(){
		
	//	List<Pet> pets = ps.getAll();
	//	return ResponseEntity.ok(pets);
	//}
	
	@GetMapping(value="/{eId}" , produces="application/json")
	public List<Application> getEmpApplications(@PathVariable("eId") int eId){
		//Get the logged in user
		Employee emp = es.getEmployeeById(eId);
		List<Application> a = as.getAll();
		List<Application> empAppList = as.getBySpecies(emp.getSpecies());
		
		//Need to filter out second approval for the employee's own species
		for (Application app : a){
			if ((app.getStatus().equals("submitted"))) {empAppList.add(app);}
			else if ((app.getStatus().equals("secondApproval"))&&(app.getPet().getBreed().getSpecies() != emp.getSpecies())) {
				empAppList.add(app);
			}
		}
		
		
		return empAppList;
	} 
	
	@GetMapping(value="customer/{cId}" , produces="application/json")
	public List<Application> getCustApplications(@PathVariable("cId") int cId){
		
		return as.getByCustomer(cId);
	} 
	
	@GetMapping("/{id}")
	public Application getById(@PathVariable("id") int id) {
		Application a = as.getApplicationById(id);
		return a;
	}
	
	
	
	@PostMapping(path="/addApplication", consumes = "application/json", produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public Application addApplication(@RequestBody Application app) {
		
		//Pet p = gson.fromJson(petJson, Pet.class);		
		return as.addApplication(app);
	}
	
	@PutMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public Application updateApplication(@PathVariable("id") int id, @RequestBody Application app) {
		if (id == app.getId()) {
			return as.updateApplication(app);
		}
		if (app.getStatus().equals("submitted")) {
			return as.updateApplication(app);
		}else if (app.getBsupapproval()) {
			app.setStatus("Second Approval");
			return as.updateApplication(app);

		}else if (app.getSecondapproval()) {
			app.setStatus("approved");
			Pet p = app.getPet();
			p.setAvailable(false);
			ps.updatePet(p);

			return as.updateApplication(app);
		}
		return null;
		
	}
	
	@DeleteMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public boolean deleteApplication(@PathVariable("id") int id) {
		Application app = as.getApplicationById(id);
//		if (app.getStatus().equals("denied")) {
//		return as.deleteApplication(app);
//		}
//		return false;
		return as.deleteApplication(app);
	}

}
