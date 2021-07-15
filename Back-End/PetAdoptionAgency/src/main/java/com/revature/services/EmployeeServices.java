package com.revature.services;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeServices {
	
public List<Employee> getAll();
	
	public Employee getEmployeeById(int id);
	
	public Employee updateEmployee(Employee e);
	
	public boolean deleteEmployee(Employee e);
	
	public Employee addEmployee(Employee e);
	
	public Employee login(String un, String pw);
	
	public Employee getBySpecies(Integer sId);

}
