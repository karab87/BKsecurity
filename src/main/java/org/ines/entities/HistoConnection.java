package org.ines.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


	
@Entity	
	public class HistoConnection implements Serializable
	{
		@Id
		@GeneratedValue
		private Long id;
		@NotNull
		
		private String unsername;
		@NotNull
		
		private String role;
		@DateTimeFormat(pattern="YYYY-MM-dd")
		private Date dateConnexion;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUnsername() {
			return unsername;
		}
		public void setUnsername(String unsername) {
			this.unsername = unsername;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public Date getDateConnexion() {
			return dateConnexion;
		}
		public void setDateConnexion(Date dateConnexion) {
			this.dateConnexion = dateConnexion;
		}
		public HistoConnection() {
			super();
			// TODO Auto-generated constructor stub
		}
		public HistoConnection(String unsername, String role, Date dateConnexion) {
			super();
			this.unsername = unsername;
			this.role = role;
			this.dateConnexion = dateConnexion;
		}
		
		
		
		


}
