package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

import biz.lcompras.calculadores.*;


@Entity
@Table(name="KAN_INFORMESMENSUALES"
 , uniqueConstraints={
     @UniqueConstraint(name="KAN_YYYYMM_DUPLICADO", columnNames={"KAN_YYYYMM"})        
 }
)
public class InformesMensuales extends SuperClaseFeliz {

	@Required
	@DescriptionsList(descriptionProperties="attn")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDATTN_ID", referencedColumnName="ID")	
	private AtencionInforme attn ;
	
	@Required
	@DescriptionsList(descriptionProperties="carreraNombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCARRERA_ID", referencedColumnName="ID")
	private Carreras carrera;	
	
	
	@Required
	@Range(min=0)	
	@Column(length=6,nullable=false,name="KAN_YYYYMM",scale=0)
	@DefaultValueCalculator(CeroFelizDouble.class)	
	private Long YYYYMM ;
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="KAN_FECHA")
	@DefaultValueCalculator(CurrentDateCalculator.class)	
	private Date fecha ;
	
	
	@Required
	@Stereotype("MEMO")
	@Column(length=500,nullable=false,name="KAN_NARRATIVA")
	private String narrativa;

	@Required
	@DescriptionsList(descriptionProperties="nombreOrientador")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDORIENTADOR_ID", referencedColumnName="ID")	
	private Orientadores orientador;

	
	public Carreras getCarrera() {
		return carrera;
	}



	public void setCarrera(Carreras carrera) {
		this.carrera = carrera;
	}



	public Long getYYYYMM() {
		return YYYYMM;
	}



	public void setYYYYMM(Long yYYYMM) {
		YYYYMM = yYYYMM;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getNarrativa() {
		return narrativa;
	}



	public void setNarrativa(String narrativa) {
		this.narrativa = narrativa;
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
