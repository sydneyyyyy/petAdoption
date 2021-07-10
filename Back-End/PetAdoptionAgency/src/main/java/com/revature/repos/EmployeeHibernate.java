package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Employee;
import com.revature.beans.Pet;
import com.revature.utils.HibernateUtil;

@Repository
public interface EmployeeHibernate extends CrudRepository<Employee, Integer> {

	public Employee findByUsername(String un);
}
