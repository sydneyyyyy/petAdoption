package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.*;

@Repository
public interface ApplicationHibernate extends JpaRepository<Application, Integer> {

}
