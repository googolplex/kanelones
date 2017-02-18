package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.util.*;

import biz.lcompras.calculadores.*;

@Entity
@Table(name="KAN_PASANTIAS"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_PASANTIA_DUPLICADA", columnNames={"KAN_YYYYMM","IDALUMNO_ID"})        
 }
)

public class Pasantias extends SuperClaseFeliz  {

	@Required
	@Range(min=0)	
	@Column(length=6,nullable=false,name="KAN_YYYYMM",scale=0)
	@DefaultValueCalculator(CeroFelizDouble.class)	
	private Long YYYYMM ;
	
	@Required
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDAREA_ID", referencedColumnName="ID")
	private AreaPasantia area;
	
	
	@Required
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDALUMNO_ID", referencedColumnName="ID")	
	private Alumnos alumno ;

	@Required
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDEMPRESA_ID", referencedColumnName="ID")	
	private Empresas empresa ;

	@Required
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDDIRECTIVO_ID", referencedColumnName="ID")	
	private Directivos directivo;
	
	@Required
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCONTACTO_ID", referencedColumnName="ID")	
	private Contactos contacto ;

	@Required
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDORIENTADOR_ID", referencedColumnName="ID")	
	private Orientadores orientador;

	
	
	public Long getYYYYMM() {
		return YYYYMM;
	}



	public void setYYYYMM(Long yYYYMM) {
		YYYYMM = yYYYMM;
	}



	public AreaPasantia getArea() {
		return area;
	}



	public void setArea(AreaPasantia area) {
		this.area = area;
	}



	public Alumnos getAlumno() {
		return alumno;
	}



	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}



	public Empresas getEmpresa() {
		return empresa;
	}



	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}



	public Directivos getDirectivo() {
		return directivo;
	}



	public void setDirectivo(Directivos directivo) {
		this.directivo = directivo;
	}



	public Contactos getContacto() {
		return contacto;
	}



	public void setContacto(Contactos contacto) {
		this.contacto = contacto;
	}



	public Orientadores getOrientador() {
		return orientador;
	}



	public void setOrientador(Orientadores orientador) {
		this.orientador = orientador;
	}



	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		


}
