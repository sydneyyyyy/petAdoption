package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Customer;

@Repository
public interface CustomerHibernate extends CrudRepository<Customer, Integer> {

}
