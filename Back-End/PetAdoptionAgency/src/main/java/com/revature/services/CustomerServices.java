package com.revature.services;

import java.util.List;

import com.revature.beans.Customer;
import com.revature.beans.Employee;

public interface CustomerServices {

public List<Customer> getAll();
	
	public Customer getCustomerById(int id);
	
	public Customer updateCustomer(Customer c);
	
	public boolean deleteCustomer(Customer c);
	
	public Customer addCustomer(Customer c);
	
	public Customer login(String un, String pw);
	
}
