package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Employee;

//test
@Repository
public interface GenericHibernate extends CrudRepository<Employee, Integer>{

}
