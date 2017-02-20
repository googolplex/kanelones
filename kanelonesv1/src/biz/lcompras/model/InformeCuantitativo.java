package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

import biz.lcompras.calculadores.*;

@Entity
@Table(name="KAN_INFORMECUANTITATIVO"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_INFORME_DUPLICADA", columnNames={"KAN_CARRERANOMBRE","KAN_ENFASIS"})        
 }
)

public class InformeCuantitativo extends SuperClaseFeliz {
	
	@ManyToOne
	@JoinColumn(name="IDINFORMEMENSUAL_ID")
	private Pasantias cabecero ;
	
	@Required
	@DescriptionsList(descriptionProperties="nombreActividad")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDACTIVIDAD_ID", referencedColumnName="ID")
	private Actividades actividad;
	
	@Required
	@Column(length=60,nullable=false,name="KAN_TAREA")
	private String tarea;

	@Required
	@DefaultValueCalculator(CeroFelizLong.class)
	private Long cantidad;

	@Required
	@DescriptionsList(descriptionProperties="lugar")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDLUGAR_ID", referencedColumnName="ID")
	private LugaresDeAtencion lugar;
	
	@Required
	@DescriptionsList(descriptionProperties="nombreOrientador")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDORIENTADOR_ID", referencedColumnName="ID")	
	private Orientadores organizador;

	// porque se puede reportar actividades fuera de fecha
	@Embedded
	private Anomes yyyymm ;	
	
	// porque se puede reportar actividades fuera de fecha
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="KAN_FECHA")
	@DefaultValueCalculator(CurrentDateCalculator.class)	
	private Date fecha ;
	


	@Required
	@Range(min=0)
	@DefaultValueCalculator(CeroFelizLong.class)
	@Column(name="KAN_EJECUTORVARON",nullable=false,length=4)
	private Long ejecutorVaron;

	@Required
	@Range(min=0)
	@DefaultValueCalculator(CeroFelizLong.class)
	@Column(name="KAN_EJECUTORMUJER",nullable=false,length=4)
	private Long ejecutorMujer;

	@Required
	@Range(min=0)
	@DefaultValueCalculator(CeroFelizLong.class)
	@Column(name="KAN_QINSTITUCIONES",nullable=false,length=4)
	private Long cantidadInstitucionesBeneficiadas;

	@Required
	@Range(min=0)
	@DefaultValueCalculator(CeroFelizLong.class)
	@Column(name="KAN_QBENEFICIARIOSVARON",nullable=false,length=4)
	private Long cantidadBeneficiariosVaron;

	@Required
	@Range(min=0)
	@DefaultValueCalculator(CeroFelizLong.class)
	@Column(name="KAN_QBENEFICIARIOSMUJER",nullable=false,length=4)
	private Long cantidadBeneficiariosMujer;

	@Column(length=60,nullable=true,name="KAN_TAREA")
	private String observacion;
	

	public Pasantias getCabecero() {
		return cabecero;
	}


	public void setCabecero(Pasantias cabecero) {
		this.cabecero = cabecero;
	}


	public Actividades getActividad() {
		return actividad;
	}


	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}


	public String getTarea() {
		return tarea;
	}


	public void setTarea(String tarea) {
		this.tarea = tarea;
	}


	public Long getCantidad() {
		return cantidad;
	}


	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}


	public LugaresDeAtencion getLugar() {
		return lugar;
	}


	public void setLugar(LugaresDeAtencion lugar) {
		this.lugar = lugar;
	}


	public Orientadores getOrganizador() {
		return organizador;
	}


	public void setOrganizador(Orientadores organizador) {
		this.organizador = organizador;
	}


	public Anomes getYyyymm() {
		return yyyymm;
	}


	public void setYyyymm(Anomes yyyymm) {
		this.yyyymm = yyyymm;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Long getEjecutorVaron() {
		return ejecutorVaron;
	}


	public void setEjecutorVaron(Long ejecutorVaron) {
		this.ejecutorVaron = ejecutorVaron;
	}


	public Long getEjecutorMujer() {
		return ejecutorMujer;
	}


	public void setEjecutorMujer(Long ejecutorMujer) {
		this.ejecutorMujer = ejecutorMujer;
	}


	public Long getCantidadInstitucionesBeneficiadas() {
		return cantidadInstitucionesBeneficiadas;
	}


	public void setCantidadInstitucionesBeneficiadas(Long cantidadInstitucionesBeneficiadas) {
		this.cantidadInstitucionesBeneficiadas = cantidadInstitucionesBeneficiadas;
	}


	public Long getCantidadBeneficiariosVaron() {
		return cantidadBeneficiariosVaron;
	}


	public void setCantidadBeneficiariosVaron(Long cantidadBeneficiariosVaron) {
		this.cantidadBeneficiariosVaron = cantidadBeneficiariosVaron;
	}


	public Long getCantidadBeneficiariosMujer() {
		return cantidadBeneficiariosMujer;
	}


	public void setCantidadBeneficiariosMujer(Long cantidadBeneficiariosMujer) {
		this.cantidadBeneficiariosMujer = cantidadBeneficiariosMujer;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	private void camposCalculados() {
		this.yyyymm.obtenerAnoMes(this.getFecha());
	}
	
	
	@PrePersist
	private void antesDeGrabar() {
		this.camposCalculados();
	}
	
	
	@PreUpdate
	private void ultimoPaso() {
		this.camposCalculados();		
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		


}
