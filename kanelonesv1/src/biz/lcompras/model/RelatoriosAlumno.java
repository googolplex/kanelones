package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;


import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

import biz.lcompras.calculadores.*;


@Entity
@Table(name="KAN_RELATORIOALUMNO"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_RELATORIO_DUPLICADO", columnNames={"IDPASANTIAS2_ID","KAN_FECHARELATORIO"})        
 }
)
@Tab(properties="cabecero2.yyyy,cabecero2.alumno.nroCedula, cabecero2.alumno.nombreApellido,fechaRelatorio,cabecero2.empresa.nombreEmpresa,horasAcumuladas,comentario")
public class RelatoriosAlumno extends SuperClaseFeliz  {

	@ManyToOne
	@JoinColumn(name="IDPASANTIAS2_ID")
	private Pasantias cabecero2 ;	
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="KAN_FECHARELATORIO")
	@DefaultValueCalculator(CurrentDateCalculator.class)	
	private Date fechaRelatorio ;

	@Min(0)
	@Column(length=10,nullable=true,name="KAN_HORASACUMULADAS")
	@DefaultValueCalculator(CeroFelizDouble.class)
	private Double horasAcumuladas;
	
	@Stereotype("MEMO")
	@Column(length=500,nullable=false,name="KAN_COMENTARIO")
	private String comentario;
	

	public Pasantias getCabecero2() {
		return cabecero2;
	}

	public void setCabecero2(Pasantias cabecero2) {
		this.cabecero2 = cabecero2;
	}

	public Date getFechaRelatorio() {
		return fechaRelatorio;
	}


	public void setFechaRelatorio(Date fechaRelatorio) {
		this.fechaRelatorio = fechaRelatorio;
	}

	public Double getHorasAcumuladas() {
		return horasAcumuladas;
	}





	public void setHorasAcumuladas(Double horasAcumuladas) {
		this.horasAcumuladas = horasAcumuladas;
	}





	public String getComentario() {
		return comentario;
	}





	public void setComentario(String comentario) {
		this.comentario = comentario.toUpperCase().trim();
	}





	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		

}
