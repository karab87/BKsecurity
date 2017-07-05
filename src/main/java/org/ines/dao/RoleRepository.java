package org.ines.dao;

import org.ines.entities.Role;
import org.ines.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String>{
	
	Role findBy(String unsername);
}
