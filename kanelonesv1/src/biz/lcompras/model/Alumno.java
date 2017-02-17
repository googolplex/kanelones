package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import org.openxava.annotations.*;
import org.openxava.util.*;


@Entity
@Table(name="KAN_ALUMNO"
 , uniqueConstraints={
        @UniqueConstraint(name="KAN_CEDULA_DUPLICADA", columnNames={"KAN_NROCEDULA"})
        , @UniqueConstraint(name="KAN_NOMBRE_DUPLICADO", columnNames={"KAN_NOMBREAPELLIDO"})        
 }
)

public class Alumno extends SuperClaseFeliz {

@Required
@Column(length=80,nullable=false,name="KAN_NROCEDULA")		
private String nroCedula ;
@Required
@Column(length=80,nullable=false,name="KAN_NOMBREAPELLIDO")
private String nombreApellido ;
@Required
@Column(length=80,nullable=false,name="KAN_NROCELULAR")
private String nroCelular;
@Required
@Column(length=80,nullable=false,name="KAN_LINEABAJA")
private String lineabaja ;
@Required
@Column(length=80,nullable=false,name="KAN_EMAIL")
private String email ;

	
	
	public String getNroCedula() {
	return nroCedula;
}



public void setNroCedula(String nroCedula) {
	this.nroCedula = nroCedula.toUpperCase().trim();
}



public String getNombreApellido() {
	return nombreApellido;
}



public void setNombreApellido(String nombreApellido) {
	this.nombreApellido = nombreApellido.toUpperCase().trim();
}



public String getNroCelular() {
	return nroCelular;
}



public void setNroCelular(String nroCelular) {
	this.nroCelular = nroCelular.toUpperCase().trim();
}



public String getLineabaja() {
	return lineabaja;
}



public void setLineabaja(String lineabaja) {
	this.lineabaja = lineabaja.toUpperCase().trim();
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email.toUpperCase().trim();
}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		


}
