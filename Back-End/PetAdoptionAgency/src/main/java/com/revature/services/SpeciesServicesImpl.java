package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Pet;
import com.revature.beans.Species;
import com.revature.repos.SpeciesHibernate;

@Service
public class SpeciesServicesImpl implements SpeciesServices {
	
	private SpeciesHibernate sh;
	
	@Autowired
	public SpeciesServicesImpl(SpeciesHibernate sh) {
		this.sh = sh;
	}

	@Override
	public List<Species> getAll() {
		// TODO Auto-generated method stub
		return (List<Species>) sh.findAll();
	}

	@Override
	public Species getPetById(int id) {
		// TODO Auto-generated method stub
		return sh.findById(id).orElse(null);
	}

	@Override
	public Species updateSpecies(Species s) {
		// TODO Auto-generated method stub
		return sh.save(s);
	}

	@Override
	public boolean deleteSpecies(Species s) {
		// TODO Auto-generated method stub
		sh.deleteById(s.getId());
		return false;
	}

	@Override
	public Species addSpecies(Species s) {
		// TODO Auto-generated method stub
		return sh.save(s);
	}

}
