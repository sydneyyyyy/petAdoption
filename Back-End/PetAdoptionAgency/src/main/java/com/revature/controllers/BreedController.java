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

import com.revature.beans.Breed;
import com.revature.beans.Pet;
import com.revature.beans.Species;
import com.revature.services.BreedServicesImpl;
import com.revature.services.PetServicesImpl;
import com.revature.services.SpeciesServicesImpl;

@RestController
@RequestMapping("/breeds")
@CrossOrigin(origins = "http://localhost:8080")
public class BreedController {
	private static final Logger logger = LoggerFactory.getLogger(BreedController.class);
	
	private BreedServicesImpl bs;
	private SpeciesServicesImpl ss;
	//public Gson gson = new Gson();
	@Autowired
	public BreedController(BreedServicesImpl bServ, SpeciesServicesImpl ss) {
		this.bs = bServ;
		this.ss = ss;
	}
	
	//@GetMapping()
	//public ResponseEntity<List<Pet>> getAllPets(){
		
	//	List<Pet> pets = ps.getAll();
	//	return ResponseEntity.ok(pets);
	//}
	
	@GetMapping(produces="application/json")
	public List<Breed> getAllPets(){
		
		List<Breed> breed = bs.getAll();
		return breed;
	} 
	
	@GetMapping("/{id}")
	public Breed getById(@PathVariable("id") int id) {
		Breed breed = bs.getBreedById(id);
		return breed;
	}
	@GetMapping("/species/{sid}")
	public List<Breed> getBySpecies(@PathVariable("sid") int id) {
		Species s = ss.getPetById(id);
		List<Breed> breeds = bs.getBySpecies(s);
		return breeds;
	}
	
	@PostMapping(path="/addBreed", consumes = "application/json", produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public Breed addBreed(@RequestBody Breed breed) {
		
		//Pet p = gson.fromJson(petJson, Pet.class);		
		return bs.addBreed(breed);
	}
	
	@PutMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public Breed updateBreed(@PathVariable("id") int id, @RequestBody Breed breed) {
		if (id == breed.getId()) {
			return bs.updateBreed(breed);
		}
		return null;
		
	}
	
	@DeleteMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public boolean deleteBreed(@PathVariable("id") int id) {
		Breed b = bs.getBreedById(id);
		return bs.deleteBreed(b);
	}

}
