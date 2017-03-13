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
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

}