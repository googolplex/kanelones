package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;



@Entity
@Table(name="KAN_INFORMESMENSUALES"
 , uniqueConstraints={
     @UniqueConstraint(name="KAN_YYYYMM_DUPLICADO", columnNames={"KAN_YYYYMM"})        
 }
)
public class InformesMensuales extends SuperClaseFeliz {

	@Required
	@DescriptionsList(descriptionProperties="yyyy,nombreCorto")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDATTN_ID", referencedColumnName="ID")	
	private AtencionInforme attn ;
	
	@Required
	@DescriptionsList(descriptionProperties="carreraNombre, enfasis")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCARRERA_ID", referencedColumnName="ID")
	private Carreras carrera;	
	
	@Embedded
	private Anomes yyyymm ;
	
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



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getNarrativa() {
		return narrativa;
	}



	public AtencionInforme getAttn() {
		return attn;
	}



	public void setAttn(AtencionInforme attn) {
		this.attn = attn;
	}



	public Anomes getYyyymm() {
		return yyyymm;
	}



	public void setYyyymm(Anomes yyyymm) {
		this.yyyymm = yyyymm;
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
