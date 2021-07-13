package com.revature.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.*;

@Repository
public interface ApplicationHibernate extends CrudRepository<Application, Integer> {

	public List<Application> findByPet(Integer pid);
	
	public List<Application> findByCustomer(Integer cid);

}
