package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_ORIENTADOR"
 , uniqueConstraints={
        @UniqueConstraint(name="KAN_NOMBRE_DUPLICADO", columnNames={"KAN_NOMBREORIENTADOR"})        
 }
)

public class Orientadores extends SuperClaseFeliz {

	@Required
	@Column(length=80,nullable=false,name="KAN_NOMBREORIENTADOR")
	private String nombreOrientador;

	
	public String getNombreOrientador() {
		return nombreOrientador;
	}

	public void setNombreOrientador(String nombreOrientador) {
		this.nombreOrientador = nombreOrientador;
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		

}
