package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.repos.CustomerHibernate;

@Service
public class CustomerServicesImpl implements CustomerServices {
	
	private CustomerHibernate ch;
	
	@Autowired
	public CustomerServicesImpl(CustomerHibernate ch) {
		this.ch = ch;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return (List<Customer>) ch.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return ch.findById(id).orElse(null);
	}

	@Override
	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return ch.save(c);
	}

	@Override
	public boolean deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		ch.deleteById(c.getId());
		return false;
	}

	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return ch.save(c);
	}

	@Override
	public Customer login(String un, String pw) {
		
		Customer cus = ch.findByUsername(un);
		if(cus != null) {
			if(cus.getPassword().equals(pw)) {
				return cus;
			}
		}
		return null;
	}

}
