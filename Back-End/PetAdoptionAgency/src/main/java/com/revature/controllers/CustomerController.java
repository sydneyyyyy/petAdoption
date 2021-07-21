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

import com.google.gson.Gson;
import com.revature.beans.*;
import com.revature.services.*;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	private CustomerServicesImpl cs;
	public Gson gson = new Gson();
	@Autowired
	public CustomerController(CustomerServicesImpl cServ) {
		this.cs = cServ;
	}
	
	//@GetMapping()
	//public ResponseEntity<List<Pet>> getAllPets(){
		
	//	List<Pet> pets = ps.getAll();
	//	return ResponseEntity.ok(pets);
	//}
	
	@GetMapping(produces="application/json")
	public List<Customer> getAllCustomer(){
		
		List<Customer> customer = cs.getAll();
		return customer;
	} 
	
	@GetMapping("/{id}")
	public Customer getById(@PathVariable("id") int id) {
		Customer customer = cs.getCustomerById(id);
		System.out.println(customer);
		return customer;
	}
	
	@PostMapping(path="/addCustomer", consumes = "application/json", produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public Customer addCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		//Pet p = gson.fromJson(petJson, Pet.class);		
		return cs.addCustomer(customer);
	}
	
	@PutMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		if (id == customer.getId()) {
			return cs.updateCustomer(customer);
		}
		return null;
		
	}
	
	@DeleteMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public boolean deleteCustomer(@PathVariable("id") int id) {
		Customer c = cs.getCustomerById(id);
		
		return cs.deleteCustomer(c);
	}

	@PostMapping(path="/login", consumes = "application/json", produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public Customer login(@RequestBody String c) {
		
		Customer cus = gson.fromJson(c, Customer.class);
		
		return cs.login(cus.getUsername(), cus.getPassword());
	}
}
