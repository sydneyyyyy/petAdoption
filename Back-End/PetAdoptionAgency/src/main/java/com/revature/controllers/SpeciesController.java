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

import com.revature.beans.Pet;
import com.revature.beans.Species;
import com.revature.services.SpeciesServicesImpl;

@RestController
@RequestMapping("/species")
@CrossOrigin(origins = "http://p2petadoption.s3-website-us-east-1.amazonaws.com")
public class SpeciesController {
	private static final Logger logger = LoggerFactory.getLogger(SpeciesController.class);
	
	private SpeciesServicesImpl ss;
	
	@Autowired
	public SpeciesController(SpeciesServicesImpl ssi) {
		this.ss = ssi;
	}
	
	@GetMapping(produces="application/json")
	public List<Species> getAllSpecies(){
		
		List<Species> s = ss.getAll();
		return s;
	} 
	
	@GetMapping("/{id}")
	public Species getById(@PathVariable("id") int id) {
		Species s = ss.getPetById(id);
		return s;
	}
	
	@PostMapping(path="/addSpecies", consumes = "application/json", produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public Species addSpecies(@RequestBody Species species) {
		
		//Pet p = gson.fromJson(petJson, Pet.class);		
		return ss.addSpecies(species);
	}
	
	@PutMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public Species updateSpecies(@PathVariable("id") int id, @RequestBody Species species) {
		if (id == species.getId()) {
			return ss.updateSpecies(species);
		}
		return null;
		
	}
	
	@DeleteMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public boolean deleteSpecies(@PathVariable("id") int id) {
		Species s = ss.getPetById(id);
		return ss.deleteSpecies(s);
	}
	

}
