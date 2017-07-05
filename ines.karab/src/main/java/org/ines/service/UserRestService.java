package org.ines.service;

import java.util.Date;
import java.util.List;

import org.ines.dao.HistoConnRepository;
import org.ines.dao.RoleRepository;
import org.ines.dao.UserRepository;
import org.ines.entities.HistoConnection;
import org.ines.entities.Role;
import org.ines.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured(value={"ROLE_ADMIN"})
public class UserRestService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HistoConnRepository histo;
	@Autowired
	private RoleRepository roleRepository;
	@RequestMapping(value="/addUser")
	public User Save(User u){
		return userRepository.save(u);
	}
	
	@RequestMapping(value="/findUsers")
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/addRole")
	public Role Save(Role r){
		return roleRepository.save(r);
	}
	
	@RequestMapping(value="/findRole")
	public List<Role> findRolesAll(){
		return roleRepository.findAll();
	}
	@RequestMapping(value="/addRoleToUser")
	public User addRoleToUser(String username, String role){
		
		User u=userRepository.findOne(username);
		Role  r=roleRepository.findOne(role);
		u.getRoles().add(r);
		userRepository.save(u);
		return u;
		
	}
	@RequestMapping(value="/histoConnexion", method=RequestMethod.POST)
	public HistoConnection histoConnexion(String username, String password){
		
		User u=userRepository.findByUnsername(username);
		HistoConnection histoCon  = new HistoConnection(u.getUnsername(),u.getRoles().toString(), new Date());
		histo.save(histoCon);
		
		return histoCon;
		
		
		
		
	}
	
	@RequestMapping(value="/index")
	public String index(){
		
		return "index";
		
			
	}
	
	@RequestMapping(value="/findhisto", method=RequestMethod.GET)
	public Page<HistoConnection> findtous(int page, int size){
		return histo.findAll(new PageRequest(page, size));
	}
}
