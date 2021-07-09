package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Pet;

@Repository
public interface PetRepo extends CrudRepository<Pet, Integer>{

	
}
