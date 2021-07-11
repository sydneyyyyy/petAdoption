package com.revature.repos;

<<<<<<< HEAD


public interface SpeciesHibernate {
=======
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Species;

@Repository
public interface SpeciesHibernate extends CrudRepository<Species, Integer> {
>>>>>>> develop

}
