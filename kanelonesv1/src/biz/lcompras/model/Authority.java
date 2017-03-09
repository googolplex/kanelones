package biz.lcompras.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "authority_unique", columnNames = { "authority" }) })
public class Authority {

	public static final String SEQUENCE = "authority_id_seq";

	@Hidden
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
	private Long id;

	@Required
	private String authority;

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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
