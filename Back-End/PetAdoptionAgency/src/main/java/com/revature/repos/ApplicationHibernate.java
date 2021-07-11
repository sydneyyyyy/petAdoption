package com.revature.repos;

<<<<<<< HEAD

public interface ApplicationHibernate {
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.*;

@Repository
public interface ApplicationHibernate extends CrudRepository<Application, Integer> {
>>>>>>> develop

}
