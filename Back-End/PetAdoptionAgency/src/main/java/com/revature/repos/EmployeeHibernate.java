package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Employee;

@Repository
public interface EmployeeHibernate extends CrudRepository<Employee, Integer> {

}
