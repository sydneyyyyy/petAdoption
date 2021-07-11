package com.revature.controllers;

import java.util.List;

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
import com.revature.beans.Pet;
import com.revature.services.ApplicationServicesImpl;

@RestController
@RequestMapping("/applications")
@CrossOrigin(origins = "http://localhost:8080")
public class ApplicationController {
	
	private ApplicationServicesImpl as;
	//public Gson gson = new Gson();
	@Autowired
	public ApplicationController(ApplicationServicesImpl appServ) {
		this.as = appServ;
	}
	
	//@GetMapping()
	//public ResponseEntity<List<Pet>> getAllPets(){
		
	//	List<Pet> pets = ps.getAll();
	//	return ResponseEntity.ok(pets);
	//}
	
	@GetMapping(produces="application/json")
	public List<Application> getAllApplication(){
		
		List<Application> a = as.getAll();
		return a;
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
		return null;
		
	}
	
	@DeleteMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public boolean deleteApplication(@PathVariable("id") int id) {
		Application app = as.getApplicationById(id);
		return as.deleteApplication(app);
	}

}
