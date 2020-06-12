package pe.edu.upc.model;

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
@Table(name="TipoJefeVentas")
public class TipoJefeVentas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idTipoJefeVentas;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="nombreTipo", nullable = false, length=60)
	private String nombreTipo;

	public TipoJefeVentas() {
		super();
	}

	public TipoJefeVentas(int idTipoJefeVentas, String nombreTipo) {
		super();
		this.idTipoJefeVentas = idTipoJefeVentas;
		this.nombreTipo = nombreTipo;
	}

	public int getIdTipoJefeVentas() {
		return idTipoJefeVentas;
	}

	public void setIdTipoJefeVentas(int idTipoJefeVentas) {
		this.idTipoJefeVentas = idTipoJefeVentas;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
      	
}
