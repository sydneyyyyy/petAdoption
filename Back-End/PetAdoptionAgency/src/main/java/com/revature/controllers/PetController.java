package com.revature.controllers;

import java.util.ArrayList;
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

import com.revature.beans.Breed;
//import com.google.gson.Gson;
import com.revature.beans.Pet;
import com.revature.services.BreedServicesImpl;
import com.revature.services.PetServicesImpl;



@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "http://localhost:4200")
public class PetController {
	private static final Logger logger = LoggerFactory.getLogger(PetController.class);

	private PetServicesImpl ps;
	private BreedServicesImpl bs;
	//public Gson gson = new Gson();
	@Autowired
	public PetController(PetServicesImpl petServ, BreedServicesImpl bs) {
		this.ps = petServ;
		this.bs = bs;
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
		List<Pet> avPets = new ArrayList();
		for (Pet p : pets) {
			if(p.isAvailable()) {
				avPets.add(p);
			}
		}
		return avPets;
	}
	
	@GetMapping("/species/{sId}")
	public List<Pet> getbySpecies(@PathVariable("sId") Integer sId){
		List<Pet> pets = ps.getBySpecies(sId);
		List<Pet> avPets = new ArrayList();
		for (Pet p : pets) {
			if(p.isAvailable()) {
				avPets.add(p);
			}
		}
		return avPets;
	}
	

	
	@PostMapping(path="/addPet", consumes = "application/json", produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public Pet addPet(@RequestBody Pet pet) {
		Pet aPet = pet;
		System.out.println(aPet);
		Breed b = bs.getByBname(aPet.getBreed().getBname());
		aPet.setBreed(b);
		System.out.println(aPet);
		//Pet p = gson.fromJson(petJson, Pet.class);		
		return ps.addpet(aPet);
		
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
