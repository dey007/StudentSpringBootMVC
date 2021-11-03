package com.nt.student.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.web.jsf.FacesContextUtils;

@Table
@Entity
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rid")
	private int rid;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(unique = true)
	private String email;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "roles", joinColumns = @JoinColumn(referencedColumnName = "rid",name = "role_id"))
	@Column(nullable = false)
	private Set<String> role;
	
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<String> getRole() {
		return role;
	}
	public void setRole(Set<String> role) {
		this.role = role;
	}

	
	
}
