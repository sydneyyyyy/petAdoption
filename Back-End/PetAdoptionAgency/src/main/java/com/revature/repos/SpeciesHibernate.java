package com.revature.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Species;
//test
@Repository
public interface SpeciesHibernate extends CrudRepository<Species, Integer> {

	
}
