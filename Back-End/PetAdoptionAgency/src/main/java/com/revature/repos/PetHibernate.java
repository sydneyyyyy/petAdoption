package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.revature.beans.Pet;
import com.revature.utils.HibernateUtil;

/*
 * This worked when I tested before we learned Spring Boot.
 * Not sure we need it now that the PetRepo is available...
 */
public class PetHibernate implements PetRepo {


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

	@Override
	public <S extends Pet> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pet> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pet> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Pet> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Pet> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pet entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Pet> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
