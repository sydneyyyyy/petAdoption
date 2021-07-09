package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Breed;

@Repository
public interface BreedHibernate extends JpaRepository<Breed, Integer> {

}
