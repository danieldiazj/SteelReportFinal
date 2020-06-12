package pe.edu.upc.model;

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
@Table(name="jefeVentas")
public class jefeVentas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idjefeVentas;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="nombjefeVentas", nullable = false, length=60)
	private String nombjefeVentas;
	
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="apelljefeVentas", nullable = false, length=60)
	private String apelljefeVentas;
	
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="dnijefeVentas", nullable = false, length=60)
	private String dnijefeVentas;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="areajefeVentas", nullable = false, length=60)
	private String areajefeVentas;
	


	@ManyToOne
	@JoinColumn(name="idTipoJefeVentas", nullable=false)
	private TipoJefeVentas tipojefeventas;



	public jefeVentas() {
		super();
		// TODO Auto-generated constructor stub
	}



	public jefeVentas(int idjefeVentas,
			 String nombjefeVentas,
			 String apelljefeVentas,
			 String dnijefeVentas,
			 String areajefeVentas,
			TipoJefeVentas tipojefeventas) {
		super();
		this.idjefeVentas = idjefeVentas;
		this.nombjefeVentas = nombjefeVentas;
		this.apelljefeVentas = apelljefeVentas;
		this.dnijefeVentas = dnijefeVentas;
		this.areajefeVentas = areajefeVentas;
		this.tipojefeventas = tipojefeventas;
	}



	public int getIdjefeVentas() {
		return idjefeVentas;
	}



	public void setIdjefeVentas(int idjefeVentas) {
		this.idjefeVentas = idjefeVentas;
	}



	public String getNombjefeVentas() {
		return nombjefeVentas;
	}



	public void setNombjefeVentas(String nombjefeVentas) {
		this.nombjefeVentas = nombjefeVentas;
	}



	public String getApelljefeVentas() {
		return apelljefeVentas;
	}



	public void setApelljefeVentas(String apelljefeVentas) {
		this.apelljefeVentas = apelljefeVentas;
	}



	public String getDnijefeVentas() {
		return dnijefeVentas;
	}



	public void setDnijefeVentas(String dnijefeVentas) {
		this.dnijefeVentas = dnijefeVentas;
	}



	public String getAreajefeVentas() {
		return areajefeVentas;
	}



	public void setAreajefeVentas(String areajefeVentas) {
		this.areajefeVentas = areajefeVentas;
	}



	public TipoJefeVentas getTipojefeventas() {
		return tipojefeventas;
	}



	public void setTipojefeventas(TipoJefeVentas tipojefeventas) {
		this.tipojefeventas = tipojefeventas;
	}

	
	
	
	
	
	
}
