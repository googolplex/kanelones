package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;


@Entity
@Table(name="KAN_ATENCIONINFORME"
 , uniqueConstraints={
     @UniqueConstraint(name="KAN_YYYY_DUPLICADO", columnNames={"KAN_YYYY"})        
 }
)
public class AtencionInforme extends SuperClaseFeliz {

	@Required
	@Range(min=0)	
	@Column(length=4,nullable=false,name="KAN_YYYY",scale=0)
	@DefaultValueCalculator(CurrentYearCalculator.class)	
	private Long YYYY ;

	@Required
	@Stereotype("MEMO")
	@Column(length=500,nullable=false,name="KAN_NARRATIVA")
	private String attn;
		
	public Long getYYYY() {
		return YYYY;
	}

	public void setYYYY(Long yYYY) {
		YYYY = yYYY;
	}



	public String getAttn() {
		return attn;
	}



	public void setAttn(String attn) {
		this.attn = attn.toUpperCase().trim();
	}



	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
	
}
