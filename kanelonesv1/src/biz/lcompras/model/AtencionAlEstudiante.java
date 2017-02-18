package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_ATENCIONALESTUDIANTE"
 , uniqueConstraints={
     @UniqueConstraint(name="KAN_YYYYMM_DUPLICADO", columnNames={"KAN_YYYYMM"})        
 }
)
public class AtencionAlEstudiante extends SuperClaseFeliz {

	private String Detalle ;
	private String hhmm;
	
	@ListProperties("fechaRelatorio")
	@OneToMany(mappedBy="cabecero",cascade=CascadeType.ALL)
	private Collection<RelatoriosAlumno> relatorio = new ArrayList<RelatoriosAlumno>() ;	
	
	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}			
}
