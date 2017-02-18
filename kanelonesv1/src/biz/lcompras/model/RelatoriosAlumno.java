package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;


@Entity
@Table(name="KAN_RELATORIOALUMNO"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_RELATORIO_DUPLICADO", columnNames={"IDPASANTIAS2_ID","KAN_FECHARELATORIO"})        
 }
)
@Tab(properties="cabecero2.alumno.nombreApellido,fechaRelatorio")
public class RelatoriosAlumno extends SuperClaseFeliz  {

	@ManyToOne
	@JoinColumn(name="IDPASANTIAS2_ID")
	private Pasantias cabecero2 ;	
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="KAN_FECHARELATORIO")
	@DefaultValueCalculator(CurrentDateCalculator.class)	
	private Date fechaRelatorio ;
	
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
