package com.revature.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Customer;
import com.revature.beans.Employee;

//test
@Repository
public interface CustomerHibernate extends CrudRepository<Customer, Integer> {





	public Customer findByUsername(String un);
}
