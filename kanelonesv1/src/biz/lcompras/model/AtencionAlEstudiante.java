package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_ATENCIONALESTUDIANTE"
 , uniqueConstraints={
     @UniqueConstraint(name="KAN_ATENCION_DUPLICADA", columnNames={"KAN_FECHAATENCION","IDALUMNO_ID"})        
 }
)
public class AtencionAlEstudiante extends SuperClaseFeliz {

	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="KAN_FECHAATENCION")
	@DefaultValueCalculator(CurrentDateCalculator.class)	
	private Date fechaAtencion ;

	
	@Required
	@DescriptionsList(descriptionProperties="nombreApellido")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDALUMNO_ID", referencedColumnName="ID")	
	private Alumnos alumno ;

	
	@Required
	@DescriptionsList(descriptionProperties="lugar")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDLUGAR_ID", referencedColumnName="ID")	
	private LugaresDeAtencion ellugar ;

	
	@Required
	@Stereotype("TIME")
	@Column(length=20,nullable=false,name="KAN_HHMM")
	private String hhmm;
			
	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public Alumnos getAlumno() {
		return alumno;
	}



	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}



	public LugaresDeAtencion getEllugar() {
		return ellugar;
	}

	public void setEllugar(LugaresDeAtencion ellugar) {
		this.ellugar = ellugar;
	}

	public String getHhmm() {
		return hhmm;
	}

	public void setHhmm(String hhmm) {
		this.hhmm = hhmm;
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}			
}
