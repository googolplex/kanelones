package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_INFORMECUANTITATIVO"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_INFORME_DUPLICADA", columnNames={"KAN_CARRERANOMBRE","KAN_ENFASIS"})        
 }
)

public class InformeCuantitativo extends SuperClaseFeliz {

	@Required
	@DescriptionsList(descriptionProperties="nombreActividad")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDACTIVIDAD_ID", referencedColumnName="ID")
	private Actividades actividad;

	@Required
	private String tarea;
	@Required
	private Long cantidad;
	@Required
	private LugaresDeAtencion lugar;
	@Required
	private Orientadores organizador;
	@Required	
	private Long mes;
	@Required
	private String ejecutorVaron;
	@Required
	private String ejecutorMujer;
	@Required
	private Long cantidadInstitucionesBeneficiadas;
	@Required
	private Long cantidadBeneficiariosVaron;
	@Required
	private Long cantidadBeneficiariosMujer;
	@Required
	private String observacion;
	
	
	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		


}
