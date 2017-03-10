package biz.lcompras.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "role_authority_unique", columnNames = { "authority_id", "role_id" }) })
public class RoleAuthority {

	public static final String SEQUENCE = "roleauthority_id_seq";

	@Hidden
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "role_authority_role_fk"))
	private Role role;

	@ManyToOne(optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "role_authority__authority_fk"))
	private Authority authority;

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

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}
