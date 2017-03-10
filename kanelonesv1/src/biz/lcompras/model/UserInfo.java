package biz.lcompras.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "userinfo_username_unique", columnNames = { "username" }) })
public class UserInfo {

	public static final String SEQUENCE = "user_id_seq";

	@Hidden
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
	private Long id;

	@Required
	private String username;

	@Required
	@Stereotype(value = "PASSWORD")
	private String password;

	@Required
	private boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
