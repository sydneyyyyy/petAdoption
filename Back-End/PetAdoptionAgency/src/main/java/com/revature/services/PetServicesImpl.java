package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Breed;
import com.revature.beans.Pet;
import com.revature.beans.Species;
import com.revature.repos.BreedHibernate;
import com.revature.repos.PetHibernate;
import com.revature.repos.PetRepo;
import com.revature.repos.SpeciesHibernate;

@Service
public class PetServicesImpl implements PetServices{

	private PetRepo pr;
	private BreedHibernate bh;
	private SpeciesHibernate sh;
	
	@Autowired
	public PetServicesImpl(PetRepo pr, BreedHibernate bh, SpeciesHibernate sh) {
		this.pr = pr;
		this.bh = bh;
		this.sh = sh;
	}
	
	@Override
	public List<Pet> getAll() {
		
		return (List<Pet>) pr.findAll();
	}

	@Override
	public Pet getPetById(int id) {
		
		return pr.findById(id).orElse(null);
	}

	@Override
	public Pet updatePet(Pet p) {
		return pr.save(p);
	}

	@Override
	public boolean deletePet(Pet p) {
		pr.deleteById(p.getId());
		return false;
	}

	@Override
	public Pet addpet(Pet p) {
		return pr.save(p);
	}

	@Override
	public List<Pet> getByBreed(Integer bId) {
		// TODO Auto-generated method stub
		Breed b = bh.findById(bId).orElse(null);
		return pr.findByBreed(b);
	}

	@Override
	public List<Pet> getBySpecies(Integer sId) {

		List<Pet> pets = new ArrayList();
		Species species = sh.findById(sId).orElse(null);
		if (species != null) {
			List<Breed> breeds = bh.findBySpecies(species);
			
			for(Breed b : breeds) {
				List<Pet> p = getByBreed(b.getId());
				pets.addAll(p);
			}
		}
		
		return pets;
	}

	@Override
	public List<Pet> getByAvailable(Boolean avail) {
		// TODO Auto-generated method stub
		return pr.findByAvailable(avail);
	}
	
	

}
