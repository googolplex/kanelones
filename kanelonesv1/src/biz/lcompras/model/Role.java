package biz.lcompras.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "role_unique", columnNames = { "rolename" }) })
public class Role {

	public static final String SEQUENCE = "role_id_seq";

	@Hidden
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
	private Long id;

	@Required
	private String rolename;

	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
