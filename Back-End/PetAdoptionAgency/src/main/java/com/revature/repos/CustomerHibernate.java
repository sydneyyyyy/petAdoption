package com.revature.repos;

<<<<<<< HEAD

public interface CustomerHibernate {
=======
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Customer;
import com.revature.beans.Employee;

@Repository
public interface CustomerHibernate extends CrudRepository<Customer, Integer> {
>>>>>>> develop

	public Customer findByUsername(String un);
}
