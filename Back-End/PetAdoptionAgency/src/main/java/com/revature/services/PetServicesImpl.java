package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Pet;
import com.revature.repos.PetHibernate;
import com.revature.repos.PetRepo;

@Service
public class PetServicesImpl implements PetServices{

	private PetRepo pr;
	
	@Autowired
	public PetServicesImpl(PetRepo pr) {
		this.pr = pr;
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

}
