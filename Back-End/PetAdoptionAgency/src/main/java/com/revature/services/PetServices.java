package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Pet;


public interface PetServices {

	public List<Pet> getAll();
	
	public Pet getPetById(int id);
	
	public Pet updatePet(Pet p);
	
	public boolean deletePet(Pet p);
	
	public Pet addpet(Pet p);
	
	public List<Pet> getByBreed(Integer bId);
	
	public List<Pet> getBySpecies(Integer sId);
	
	public List<Pet> getByAvailable(Boolean avail);
	
	public List<Pet> getByGender(String gender);
}
