package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_EMPRESA"
 , uniqueConstraints={
        @UniqueConstraint(name="KAN_EMPRESA_DUPLICADA", columnNames={"KAN_NOMBREEMPRESA"})        
 }
)
public class Empresas extends SuperClaseFeliz {

@Column(length=80,nullable=false,name="KAN_NOMBREEMPRESA")
@Required
private String nombreEmpresa;

@Column(length=80,nullable=false,name="KAN_DIRECCIONEMPRESA")
@Required
private String direccionEmpresa;

@Stereotype("TELEPHONE")
@Required
@Column(length=80,nullable=false,name="KAN_TELEFONO")
private String telefono;

@Stereotype("EMAIL")
@Required
@Column(length=80,nullable=false,name="KAN_EMAILEMPRESA")
private String email;

public String getNombreEmpresa() {
	return nombreEmpresa;
}


public void setNombreEmpresa(String nombreEmpresa) {
	this.nombreEmpresa = nombreEmpresa.toUpperCase().trim();
}

public String getDireccionEmpresa() {
	return direccionEmpresa;
}

public void setDireccionEmpresa(String direccionEmpresa) {
	this.direccionEmpresa = direccionEmpresa.toUpperCase().trim();
}


public String getTelefono() {
	return telefono;
}


public void setTelefono(String telefono) {
	this.telefono = telefono.toUpperCase().trim();
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
