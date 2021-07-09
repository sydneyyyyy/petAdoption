package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Breed;

@Repository
public interface BreedHibernate extends CrudRepository<Breed, Integer> {

}
