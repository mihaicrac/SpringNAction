package com.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="users")
public class Spitter {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id; 
	

	@NotEmpty
	@NotNull
	@Size(min = 5, max = 16)
	@Column(name="username")
	private String username;
	
	@NotEmpty
	@NotNull
	@Size(min = 5, max = 25)
	@Column(name="password")
	private String password;
	
	
	@NotEmpty
	@NotNull
	@Size(min = 2, max = 30)
	@Column(name="firstname")
	private String firstName;
	
	@NotEmpty
	@NotNull
	@Size(min = 2, max = 30)
	@Column(name="lastname")
	private String lastName;
	
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	

	public Spitter() {
		// TODO Auto-generated constructor stub
		
	}
	

	public Spitter(String username, String password, String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	public Spitter(Long l, String username, String password, String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		this(username, password, firstName, lastName);
		this.id = l;
	}
	
	
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	public boolean equals(Object o){
		Spitter s = ((Spitter)o);
		if(!s.firstName.equals(this.firstName))
			return false;
		if(!s.lastName.equals(this.lastName))
			return false;
		if(!s.password.equals(this.password))
			return false;
		if(!s.username.equals(this.username))
			return false;
		if(s.id != this.id)
			return false;
		
		return true;
		
	}
	
	
}