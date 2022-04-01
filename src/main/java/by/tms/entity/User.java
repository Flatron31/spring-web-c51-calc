package by.tms.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Must be")
	@NotEmpty(message = "Must be")

	private String name;

	@NotBlank(message = "Must be")
	@NotEmpty(message = "Must be")
	private String password;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private List<Operation> operation;

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
//		if (operation != null) {
//			operation.forEach(o->o.set);
//		}
		this.operation = operation;
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public User() {
	}

	public User(long id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
