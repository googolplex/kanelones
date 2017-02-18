package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.util.*;


@Entity
@Table(name="KAN_ALUMNO"
 , uniqueConstraints={
        @UniqueConstraint(name="KAN_CEDULA_DUPLICADA", columnNames={"KAN_NROCEDULA"})
        , @UniqueConstraint(name="KAN_NOMBRE_DUPLICADO", columnNames={"KAN_NOMBREAPELLIDO"})        
 }
)

public class Alumnos extends SuperClaseFeliz {

@Required
@Column(length=20,nullable=false,name="KAN_NROCEDULA")
@Pattern(regexp="^[0-9]+$",message="No es un numero")
private String nroCedula ;
@Required
@Column(length=80,nullable=false,name="KAN_NOMBREAPELLIDO")
private String nombreApellido ;

@Required
@Stereotype("TELEPHONE")
@Column(length=40,nullable=false,name="KAN_NROCELULAR1")
private String nroCelular1;

@Required
@Stereotype("TELEPHONE")
@Column(length=40,nullable=false,name="KAN_NROCELULAR2")
private String nroCelular2;


@Required
@Column(length=40,nullable=false,name="KAN_LINEABAJA")
private String lineabaja ;


@Required
@Column(length=80,nullable=false,name="KAN_EMAIL")
@Stereotype("EMAIL")
private String email ;

@Required 
@Column(length=80,nullable=true,name="KAN_DIRECCION")
private String direccion; 

@Required
@Column(nullable=true	,name="KAN_YYYY")
private Long YYYY;

	
	
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






public String getNroCelular1() {
	return nroCelular1;
}



public void setNroCelular1(String nroCelular1) {
	this.nroCelular1 = nroCelular1.toUpperCase().trim();
}



public String getNroCelular2() {
	return nroCelular2;
}



public void setNroCelular2(String nroCelular2) {
	this.nroCelular2 = nroCelular2.toUpperCase().trim();
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




	public String getDireccion() {
	return direccion;
}



public void setDireccion(String direccion) {
	this.direccion = direccion;
}



	public Long getYYYY() {
	return YYYY;
}



public void setYYYY(Long yYYY) {
	YYYY = yYYY;
}



	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		


}
