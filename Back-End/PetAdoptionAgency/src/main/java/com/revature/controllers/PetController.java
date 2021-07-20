package com.revature.controllers;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//import com.google.gson.Gson;
import com.revature.beans.Pet;
import com.revature.services.PetServicesImpl;



@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "http://localhost:8080")
public class PetController {
	private static final Logger logger = LoggerFactory.getLogger(PetController.class);

	private PetServicesImpl ps;
	//public Gson gson = new Gson();
	@Autowired
	public PetController(PetServicesImpl petServ) {
		this.ps = petServ;
	}
	
	//@GetMapping()
	//public ResponseEntity<List<Pet>> getAllPets(){
		
	//	List<Pet> pets = ps.getAll();
	//	return ResponseEntity.ok(pets);
	//}
	
	@GetMapping(produces="application/json")
	public List<Pet> getAllPets(){
		
		List<Pet> pets = ps.getAll();
		return pets;
	} 
	
	@GetMapping("/{id}")
	public Pet getById(@PathVariable("id") int id) {
		Pet pet = ps.getPetById(id);
		return pet;
	}
	
	@GetMapping("/available/{isAvailable}")
	public List<Pet> getByAvailable(@PathVariable("isAvailable") Boolean isAv){
		List<Pet> pets = ps.getByAvailable(isAv);
		return pets;
	}
	
	@GetMapping("/breed/{bId}")
	public List<Pet> getByBreed(@PathVariable("bId") Integer bId){
		List<Pet> pets = ps.getByBreed(bId);
		return pets;
	}
	
	@GetMapping("/species/{sId}")
	public List<Pet> getbySpecies(@PathVariable("sId") Integer sId){
		List<Pet> pets = ps.getBySpecies(sId);
		return pets;
	}
	

	
	@PostMapping(path="/addPet", consumes = "application/json", produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public Pet addPet(@RequestBody Pet pet) {
		System.out.println(pet);
		//Pet p = gson.fromJson(petJson, Pet.class);		
		return ps.addpet(pet);
	}
	
	@PutMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public Pet updatePet(@PathVariable("id") int id, @RequestBody Pet pet) {
		if (id == pet.getId()) {
			return ps.updatePet(pet);
		}
		return null;
		
	}
	
	@DeleteMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public boolean deletePet(@PathVariable("id") int id) {
		Pet p = ps.getPetById(id);
		return ps.deletePet(p);
	}
	
	
	
}
