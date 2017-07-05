package org.ines.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table(name="users")
public class User implements Serializable{
	@Id
	private String unsername;
	private String password;
	private boolean actived;
	@ManyToMany
	@JoinTable(name="USER_ROLES")
	private Collection<Role> roles;
	public String getUnsername() {
		return unsername;
	}
	public void setUnsername(String unsername) {
		this.unsername = unsername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public User(String unsername, String password, boolean actived,
			Collection<Role> roles) {
		super();
		this.unsername = unsername;
		this.password = password;
		this.actived = actived;
		this.roles = roles;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
}
