package com.revature.services;

import java.util.List;

import com.revature.beans.Breed;
import com.revature.beans.Pet;
import com.revature.beans.Species;

public interface BreedServices {
	
public List<Breed> getAll();
	
	public Breed getBreedById(int id);
	
	public Breed updateBreed(Breed b);
	
	public boolean deleteBreed(Breed b);
	
	public Breed addBreed(Breed b);
	
	public List<Breed> getBySpecies(Species species);

}
