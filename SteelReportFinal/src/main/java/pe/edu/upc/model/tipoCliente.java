package pe.edu.upc.model;
//js
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tipoCliente")
public class tipoCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idtipoCliente;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="nombtipoCliente", nullable = false, length=60)
	private String nombtipoCliente;

	public tipoCliente() {
		super();
	}

	public tipoCliente(int idtipoCliente, String nombtipoCliente) {
		super();
		this.idtipoCliente = idtipoCliente;
		this.nombtipoCliente = nombtipoCliente;
	}
	
	public int getIdtipoCliente() {
		return idtipoCliente;
	}

	public void setIdtipoCliente(int idtipoCliente) {
		this.idtipoCliente = idtipoCliente;
	}

	public String getNombtipoCliente() {
		return nombtipoCliente;
	}

	public void setNombtipoCliente(String nombtipoCliente) {
		this.nombtipoCliente = nombtipoCliente;
	}
	
}
