package com.revature.repos;

<<<<<<< HEAD

=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
>>>>>>> 13f4a24893fe7a2c25da8fafdffb2de596cd9654
import org.springframework.stereotype.Repository;

import com.revature.beans.*;

<<<<<<< HEAD

public interface ApplicationHibernate {
=======
@Repository
public interface ApplicationHibernate extends CrudRepository<Application, Integer> {
>>>>>>> 13f4a24893fe7a2c25da8fafdffb2de596cd9654

}
