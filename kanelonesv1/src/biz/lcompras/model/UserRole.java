package biz.lcompras.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "userrole_unique", columnNames = { "userinfo_id", "role_id" }) })
public class UserRole {

	public static final String SEQUENCE = "userrole_id_seq";

	@Hidden
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "userrole_user_fk"))
	private UserInfo userInfo;

	@ManyToOne(optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "userrole_role_fk"))
	private Role role;

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
