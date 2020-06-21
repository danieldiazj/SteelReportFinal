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
@Table(name="Tipocliente")
public class Tipocliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idTipocliente;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar vacio")
	@Column(name="nombTipocliente", nullable = false, length=60, unique= true)
	private String nombTipocliente;

	public Tipocliente() {
		super();
	}

	public Tipocliente(int idTipocliente,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar vacio") String nombTipocliente) {
		super();
		this.idTipocliente = idTipocliente;
		this.nombTipocliente = nombTipocliente;
	}

	public int getIdTipocliente() {
		return idTipocliente;
	}

	public void setIdTipocliente(int idTipocliente) {
		this.idTipocliente = idTipocliente;
	}

	public String getNombTipocliente() {
		return nombTipocliente;
	}

	public void setNombTipocliente(String nombTipocliente) {
		this.nombTipocliente = nombTipocliente;
	}
  
}
