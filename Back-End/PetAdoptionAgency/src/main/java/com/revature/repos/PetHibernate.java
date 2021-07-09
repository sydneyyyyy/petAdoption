package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Pet;
import com.revature.utils.HibernateUtil;


/*
 * This worked when I tested before we learned Spring Boot.
 * Not sure we need it now that the PetRepo is available...
 */
public class PetHibernate {

	public List<Pet> getAll(){
		Session s = HibernateUtil.getSession();
		
		List<Pet> petList = null;
		
		try {
			petList = s.createQuery("FROM Pet").list();
			
		}
		catch(HibernateException e){
			//e.printStackTrace();
			System.out.println("getAll pets issue");
		}
		finally {
			s.close();
		}
		
		return petList;
	}
	
	public void add(Pet pet) {
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		
		try {
			t = s.beginTransaction();
			s.save(pet);
			t.commit();
		}
		catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
		
		
	}
}
