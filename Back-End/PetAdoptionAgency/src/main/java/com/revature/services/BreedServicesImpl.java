package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Breed;
import com.revature.repos.*;

@Service
public class BreedServicesImpl implements BreedServices {
	
	private BreedHibernate bh;
	
	@Autowired
	public BreedServicesImpl (BreedHibernate bh) {
		this.bh = bh;
	}

	@Override
	public List<Breed> getAll() {
		// TODO Auto-generated method stub
		return (List<Breed>) bh.findAll();
		
	}

	@Override
	public Breed getBreedById(int id) {
		// TODO Auto-generated method stub
		return bh.findById(id).orElse(null);
	}

	@Override
	public Breed updateBreed(Breed b) {
		// TODO Auto-generated method stub
		return bh.save(b);
	}

	@Override
	public boolean deleteBreed(Breed b) {
		// TODO Auto-generated method stub
		bh.deleteById(b.getId());
		return false;
	}

	@Override
	public Breed addBreed(Breed b) {
		// TODO Auto-generated method stub
		return bh.save(b);
	}

}
