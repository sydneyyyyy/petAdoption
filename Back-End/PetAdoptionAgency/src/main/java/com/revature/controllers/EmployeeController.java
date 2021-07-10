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

import com.google.gson.Gson;
import com.revature.beans.Employee;
import com.revature.beans.Pet;
import com.revature.services.EmployeeServicesImpl;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:8080")
public class EmployeeController {
	
	private EmployeeServicesImpl es;
	public Gson gson = new Gson();
	@Autowired
	public EmployeeController(EmployeeServicesImpl eServ) {
		this.es = eServ;
	}
	
	//@GetMapping()
	//public ResponseEntity<List<Pet>> getAllPets(){
		
	//	List<Pet> pets = ps.getAll();
	//	return ResponseEntity.ok(pets);
	//}
	
	@GetMapping(produces="application/json")
	public List<Employee> getAllEmployee(){
		
		List<Employee> e = es.getAll();
		return e;
	} 
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable("id") int id) {
		Employee e = es.getEmployeeById(id);
		return e;
	}
	
	@PostMapping(path="/addEmployee", consumes = "application/json", produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public Employee addEmployee(@RequestBody Employee e) {
		
		//Pet p = gson.fromJson(petJson, Pet.class);		
		return es.addEmployee(e);
	}
	
	@PutMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee e) {
		if (id == e.getId()) {
			return es.updateEmployee(e);
		}
		return null;
		
	}
	
	@DeleteMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public boolean deleteEmployee(@PathVariable("id") int id) {
		Employee e = es.getEmployeeById(id);
		return es.deleteEmployee(e);
	}
	
	@PostMapping(path="/login", consumes = "application/json", produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public Employee login(@RequestBody String emp) {
		
		Employee e = gson.fromJson(emp, Employee.class);
		
		return es.login(e.getUsername(), e.getPassword());
	}

}
