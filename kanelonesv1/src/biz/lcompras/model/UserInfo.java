package biz.lcompras.model;

import javax.persistence.*;
import javax.validation.constraints.*;

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

	@NotNull
	private Boolean active = true;

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
