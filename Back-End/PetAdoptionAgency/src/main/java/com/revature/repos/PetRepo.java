package com.revature.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Breed;
import com.revature.beans.Pet;

@Repository
public interface PetRepo extends CrudRepository<Pet, Integer>{

	public List<Pet> findByBreed(Breed breed);
}
