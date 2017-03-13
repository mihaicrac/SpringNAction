package spittr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spitter {
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 16)
	private String username;
	
	@NotNull
	@Size(min = 5, max = 25)
	private String password;
	
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

	
	public Spitter(long l, String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
		this(string, string2, string3, string4);
		this.id = l;
	}
	
	
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

}