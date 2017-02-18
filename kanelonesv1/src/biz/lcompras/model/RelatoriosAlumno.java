package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;


@Entity
@Table(name="KAN_RELATORIOALUMNO"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_RELATORIO_DUPLICADO", columnNames={"IDPASANTIAS_ID","KAN_FECHARELATORIO","IDALUMNO_ID"})        
 }
)

public class RelatoriosAlumno extends SuperClaseFeliz  {

	@ManyToOne
	@JoinColumn(name="IDPASANTIAS_ID")
	private Pasantias cabecero ;	
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="KAN_FECHARELATORIO")
	@DefaultValueCalculator(CurrentDateCalculator.class)	
	private Date fechaRelatorio ;
	
	@Required
	@DescriptionsList(descriptionProperties="nombreApellido")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDALUMNO_ID", referencedColumnName="ID")
	private Alumnos alumno ;

	@Stereotype("MEMO")
	@Column(length=500,nullable=false,name="KAN_COMENTARIO")
	private String comentario;
	


	public Pasantias getCabecero() {
		return cabecero;
	}



	public void setCabecero(Pasantias cabecero) {
		this.cabecero = cabecero;
	}



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



	public String getComentario() {
		return comentario;
	}



	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		

}
