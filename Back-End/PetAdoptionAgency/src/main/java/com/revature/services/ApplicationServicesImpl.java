package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Application;
import com.revature.beans.Breed;
import com.revature.beans.Pet;
import com.revature.beans.Species;
import com.revature.repos.ApplicationHibernate;
import com.revature.repos.BreedHibernate;
import com.revature.repos.PetRepo;

@Service
public class ApplicationServicesImpl implements ApplicationServices {
	
	private ApplicationHibernate ah;
	private PetRepo pr;
	private BreedHibernate bh;
	
	@Autowired
	public ApplicationServicesImpl(ApplicationHibernate ah, PetRepo pr, BreedHibernate bh) {
		this.ah = ah;
		this.pr = pr;
		this.bh = bh;
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

	@Override
	public List<Application> getApplicationByCustomer(Integer cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Application> getBySpecies(Species species) {
		List<Application> appList = new ArrayList();
		List<Pet> petList = new ArrayList();
		List<Breed> bList = bh.findBySpecies(species);
		
		for(Breed b : bList ) {
			petList.addAll(pr.findByBreed(b));
		}
		
		for (Pet p : petList) {
			appList.addAll(ah.findByPet(p.getId()));
		}
		//to get by petId we first need to find all pets with species
		//then for each pet with that species we want to find the application by PID and add it to appList
		for (Application app : appList) {
			if((app.getBsupapproval())||(app.getStatus().equals("denied"))) {
				appList.remove(app);
			}
		}
		//List<Application> aPList = ah.fin
		return appList;
	}

	@Override
	public List<Application> getByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Application> getByPid(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Application> getByCustomer(Integer cId) {
		
		return ah.findByCustomer(cId);
	}

	

}
