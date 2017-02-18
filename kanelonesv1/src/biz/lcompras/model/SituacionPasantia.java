package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_SITUACIONPASANTIA"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_SITUACION_DUPLICADA", columnNames={"KAN_FECHARELATORIO","IDESTADO_ID"})        
 }
)

public class SituacionPasantia extends SuperClaseFeliz {

	@ManyToOne
	@JoinColumn(name="IDPASANTIAS_ID")
	private Pasantias cabecero ;	
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="KAN_FECHARELATORIO")
	@DefaultValueCalculator(CurrentDateCalculator.class)	
	private Date fechaSituacion ;

	@Required
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDESTADO_ID", referencedColumnName="ID")
	private EstadosPasantia estado ; 
	

	
	public Pasantias getCabecero() {
		return cabecero;
	}



	public void setCabecero(Pasantias cabecero) {
		this.cabecero = cabecero;
	}



	public Date getFechaRelatorio() {
		return fechaSituacion;
	}



	public void setFechaRelatorio(Date fechaRelatorio) {
		this.fechaSituacion = fechaRelatorio;
	}



	public EstadosPasantia getEstado() {
		return estado;
	}



	public void setEstado(EstadosPasantia estado) {
		this.estado = estado;
	}



	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
}
