package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

import biz.lcompras.calculadores.*;

@Entity
@Table(name="KAN_RELATORIOALUMNO"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_YYYYMM_DUPLICADO", columnNames={"KAN_YYYYMM","KAN_IDALUMNO_ID"})        
 }
)

public class RelatoriosAlumno extends SuperClaseFeliz  {


	@Required
	@Range(min=0)	
	@Column(length=6,nullable=false,name="KAN_YYYYMM",scale=0)
	@DefaultValueCalculator(CeroFelizDouble.class)	
	private Long YYYYMM ;
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="KAN_FECHARELATORIO")
	@DefaultValueCalculator(CurrentDateCalculator.class)	
	private Date fechaRelatorio ;
	
	@Required
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDALUMNO_ID", referencedColumnName="ID")
	private Alumnos alumno ;

	
	@Required	
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDPASANTIA_ID", referencedColumnName="ID")
	private Pasantias pasantia;

	
	@Required
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDPASANTIA_ID", referencedColumnName="ID")
	private String relatorio;
	
	
	public Date getFechaRelatorio() {
		return fechaRelatorio;
	}


	public void setFechaRelatorio(Date fechaRelatorio) {
		this.fechaRelatorio = fechaRelatorio;
	}


	public Alumnos getAlumno() {
		return alumno;
	}


	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}


	public Pasantias getPasantia() {
		return pasantia;
	}


	public void setPasantia(Pasantias pasantia) {
		this.pasantia = pasantia;
	}



	public String getRelatorio() {
		return relatorio;
	}



	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio.toUpperCase().trim();
	}


	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		

}
