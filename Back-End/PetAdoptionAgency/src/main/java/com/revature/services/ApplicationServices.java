package com.revature.services;

import java.util.List;

import com.revature.beans.Application;

public interface ApplicationServices {
	
public List<Application> getAll();
	
	public Application getApplicationById(int id);
	
	public Application updateApplication(Application a);
	
	public boolean deleteApplication(Application a);
	
	public Application addApplication(Application a);

}
