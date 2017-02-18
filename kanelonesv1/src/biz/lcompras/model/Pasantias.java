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
	@DescriptionsList(descriptionProperties="nombreArea")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDAREA_ID", referencedColumnName="ID")
	private AreaPasantia area;
	
	@Required
	@DescriptionsList(descriptionProperties="carreraNombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCARRERA_ID", referencedColumnName="ID")
	private Carreras carrera;	
	
	
	@Required
	@DescriptionsList(descriptionProperties="nombreApellido")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDALUMNO_ID", referencedColumnName="ID")	
	private Alumnos alumno ;

	@Required
	@DescriptionsList(descriptionProperties="nombreEmpresa")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDEMPRESA_ID", referencedColumnName="ID")	
	private Empresas empresa ;

	@Required
	@DescriptionsList(descriptionProperties="directivoNombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDDIRECTIVO_ID", referencedColumnName="ID")	
	private Directivos directivo;
	
	@Required
	@DescriptionsList(descriptionProperties="nombreContacto")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCONTACTO_ID", referencedColumnName="ID")	
	private Contactos contacto ;

	@Required
	@DescriptionsList(descriptionProperties="nombreOrientador")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDORIENTADOR_ID", referencedColumnName="ID")	
	private Orientadores orientador;

	@ListProperties("estado.nombreEstado,fechaSituacion")
	@OneToMany(mappedBy="cabecero",cascade=CascadeType.ALL)
	private Collection<SituacionPasantia> situacion = new ArrayList<SituacionPasantia>() ;	
	
	@ListProperties("fechaRelatorio")
	@OneToMany(mappedBy="cabecero",cascade=CascadeType.ALL)
	private Collection<RelatoriosAlumno> relatorio = new ArrayList<RelatoriosAlumno>() ;
	
	



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



	public Carreras getCarrera() {
		return carrera;
	}





	public void setCarrera(Carreras carrera) {
		this.carrera = carrera;
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





	public Collection<SituacionPasantia> getSituacion() {
		return situacion;
	}





	public void setSituacion(Collection<SituacionPasantia> situacion) {
		this.situacion = situacion;
	}





	public Collection<RelatoriosAlumno> getRelatorio() {
		return relatorio;
	}





	public void setRelatorio(Collection<RelatoriosAlumno> relatorio) {
		this.relatorio = relatorio;
	}





	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		


}
