package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Application;
import com.revature.beans.Pet;
import com.revature.repos.ApplicationHibernate;
import com.revature.repos.PetRepo;

@Service
public class ApplicationServicesImpl implements ApplicationServices {
	
	private ApplicationHibernate ah;
	
	@Autowired
	public ApplicationServicesImpl(ApplicationHibernate ah) {
		this.ah = ah;
	}

	@Override
	public List<Application> getAll() {
		// TODO Auto-generated method stub
		return (List<Application>) ah.findAll();
	}

	@Override
	public Application getApplicationById(int id) {
		// TODO Auto-generated method stub
		return ah.findById(id).orElse(null);
	}

	@Override
	public Application updateApplication(Application a) {
		// TODO Auto-generated method stub
		return ah.save(a);
	}

	@Override
	public boolean deleteApplication(Application a) {
		// TODO Auto-generated method stub
		ah.deleteById(a.getId());
		return false;
	}

	@Override
	public Application addApplication(Application a) {
		// TODO Auto-generated method stub
		return ah.save(a);
	}

}
