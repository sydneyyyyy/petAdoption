package com.revature.repos;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Breed;
import com.revature.beans.Customer;
import com.revature.beans.Pet;
import com.revature.beans.Species;

public interface BreedHibernate extends CrudRepository<Breed, Integer>{


	public List<Breed> findBySpecies(Species species);
}
