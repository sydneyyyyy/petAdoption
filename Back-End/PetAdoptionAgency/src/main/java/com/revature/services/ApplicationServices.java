package com.revature.services;

import java.util.List;

import com.revature.beans.Application;
import com.revature.beans.Customer;
import com.revature.beans.Species;

public interface ApplicationServices {
	
public List<Application> getAll();
	
	public Application getApplicationById(int id);
	
	public Application updateApplication(Application a);
	
	public boolean deleteApplication(Application a);
	
	public Application addApplication(Application a);
	
	public List<Application> getApplicationByCustomer(Integer cId);
	
	public List<Application> getByPid(Integer pid);
	
	//this will return a list of applications that the bApproval is false and matches the given species
	public List<Application> getBySpecies(Species species);
	
	//return a list of applications where the bAprrovalisTrue and the employee species is not the application species
	public List<Application> getByStatus(String status);

	public List<Application> getByCustomer(Integer cId);
}
