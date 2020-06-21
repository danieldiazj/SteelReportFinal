package pe.edu.upc.model;
//obra
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Obra")
public class Obra implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idObra;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="nombreObra", nullable = false, length=60, unique= true) //las obras siempre tienen distintos nombres
	private String nombreObra;
	
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="responsableObra", nullable = false, length=60)
	private String responsableObra; 
	

	@ManyToOne
	@JoinColumn(name="idCliente", nullable=false)
	private Cliente cliente; 



	public Obra() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Obra(int idObra, String nombreObra, String responsableObra,Cliente cliente) {
		super();
		this.idObra = idObra;
		this.nombreObra = nombreObra;
		this.responsableObra = responsableObra;
		this.cliente = cliente;
	}

	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	public String getNombreObra() {
		return nombreObra;
	}

	public void setNombreObra(String nombreObra) {
		this.nombreObra = nombreObra;
	}

	public String getResponsableObra() {
		return responsableObra;
	}

	public void setResponsableObra(String responsableObra) {
		this.responsableObra = responsableObra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
}
