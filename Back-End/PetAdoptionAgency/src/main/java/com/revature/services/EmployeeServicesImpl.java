package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Employee;
import com.revature.beans.Pet;
import com.revature.repos.EmployeeHibernate;

@Service
public class EmployeeServicesImpl implements EmployeeServices {
	
private EmployeeHibernate eh;
	
	@Autowired
	public EmployeeServicesImpl(EmployeeHibernate eh) {
		this.eh = eh;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return (List<Employee>) eh.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return eh.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return eh.save(e);
	}

	@Override
	public boolean deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		eh.deleteById(e.getId());
		return false;
	}

	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return eh.save(e);
	}

}
