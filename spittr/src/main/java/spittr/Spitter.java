package spittr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
	private Long id;
	

	@NotNull
	@Size(min = 5, max = 16)
	private String username;
	
	@NotNull
	@Size(min = 5, max = 25)
	private String password;
	
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


	@NotNull
	@Size(min = 2, max = 30)
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String lastName;

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

	
	public Spitter(long l, String username, String password, String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		this(username, password, firstName, lastName);
		this.id = l;
	}
	
	
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

}