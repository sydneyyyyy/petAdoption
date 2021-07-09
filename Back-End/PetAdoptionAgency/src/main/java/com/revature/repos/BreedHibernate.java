package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Breed;

<<<<<<< HEAD

public interface BreedHibernate {
=======
@Repository
public interface BreedHibernate extends CrudRepository<Breed, Integer> {
>>>>>>> 13f4a24893fe7a2c25da8fafdffb2de596cd9654

}
