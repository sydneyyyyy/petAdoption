package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Pet;

@Repository
public interface PetHibernate extends JpaRepository<Pet, Integer> {

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
