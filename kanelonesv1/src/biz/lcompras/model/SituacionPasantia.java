package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;


public class SituacionPasantia extends SuperClaseFeliz {

	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="KAN_FECHARELATORIO")
	@DefaultValueCalculator(CurrentDateCalculator.class)	
	private Date fechaRelatorio ;

	@Required
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDESTADO_ID", referencedColumnName="ID")
	private EstadosPasantia estado ; 
	
	
	public Date getFechaRelatorio() {
		return fechaRelatorio;
	}

	public void setFechaRelatorio(Date fechaRelatorio) {
		this.fechaRelatorio = fechaRelatorio;
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
