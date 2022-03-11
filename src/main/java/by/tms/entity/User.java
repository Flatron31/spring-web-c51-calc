package by.tms.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

public class User {

	@NotBlank  (message = "Must be")
	@NotEmpty (message = "Must be")
	private String name;

	@NotBlank
	@NotEmpty
//	@Pattern(regexp = )
//	@Max(45)
//	@Range(min = 3, max = 45)
//	@Email(regexp = )
	private String password;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
