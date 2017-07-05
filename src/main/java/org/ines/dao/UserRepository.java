package org.ines.dao;

import org.ines.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
	
	User findByUnsername(String unsername);

}
