package com.revature.services;

import java.util.List;

import com.revature.beans.Species;

public interface SpeciesServices {
	
public List<Species> getAll();
	
	public Species getPetById(int id);
	
	public Species updateSpecies(Species s);
	
	public boolean deleteSpecies(Species s);
	
	public Species addSpecies(Species s);

}
