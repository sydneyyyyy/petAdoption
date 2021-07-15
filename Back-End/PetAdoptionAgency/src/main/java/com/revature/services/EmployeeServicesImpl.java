package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Employee;
import com.revature.beans.Pet;
import com.revature.beans.Species;
import com.revature.repos.EmployeeHibernate;
import com.revature.repos.SpeciesHibernate;

@Service
public class EmployeeServicesImpl implements EmployeeServices {
	
	private EmployeeHibernate eh;
	private SpeciesHibernate sh;
	
	@Autowired
	public EmployeeServicesImpl(EmployeeHibernate eh, SpeciesHibernate sh) {
		this.eh = eh;
		this.sh = sh;
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

	@Override
	public Employee login(String un, String pw) {
		// TODO Auto-generated method stub
		Employee emp = eh.findByUsername(un);
		if(emp != null) {
			if(emp.getPassword().equals(pw)) {
				return emp;
			}
		}
		return null;
	}

	@Override
	public Employee getBySpecies(Integer sId) {
		
		Species s = sh.findById(sId).orElse(null);
		if (s != null) {
			return eh.findBySpecies(s);
		}
		
		return null;
	}

}
