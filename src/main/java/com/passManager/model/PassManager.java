package com.passManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userpassdata")
public class PassManager {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "User")
	private String user;
	@Column(name = "Password")
	private String password;
	@Column(name = "Application")
	private String application;
	public PassManager() {
		
	}
	public PassManager(long id, String user, String password, String application) {
		this.id = id;
		this.user = user;
		this.password = password;
		this.application = application;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	
}
