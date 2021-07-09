package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Pet;

@Repository
public interface PetHibernate extends JpaRepository<Pet, Integer> {

}
