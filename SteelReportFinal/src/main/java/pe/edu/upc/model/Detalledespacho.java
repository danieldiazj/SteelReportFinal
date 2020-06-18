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
@Table(name="Detalledespacho")
public class Detalledespacho implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idDetalledespacho;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="lugardDespacho", nullable = false, length=90)
	private String lugardDespacho;
	
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="nombdDespacho", nullable = false, length=90)
	private String nombdDespacho;
	
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="cantidaddDespacho", nullable = false, length=90)
	private String cantidaddDespacho;
	
	@ManyToOne
	@JoinColumn(name="idProducto", nullable=false)
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="idOrdendespacho", nullable=false)
	private Ordendespacho ordendespacho;

	public Detalledespacho() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Detalledespacho(int idDetalledespacho,
			 String lugardDespacho,
			 String nombdDespacho,
			 String cantidaddDespacho,
			Producto producto, Ordendespacho ordendespacho) {
		super();
		this.idDetalledespacho = idDetalledespacho;
		this.lugardDespacho = lugardDespacho;
		this.nombdDespacho = nombdDespacho;
		this.cantidaddDespacho = cantidaddDespacho;
		this.producto = producto;
		this.ordendespacho = ordendespacho;
	}

	public int getIdDetalledespacho() {
		return idDetalledespacho;
	}

	public void setIdDetalledespacho(int idDetalledespacho) {
		this.idDetalledespacho = idDetalledespacho;
	}

	public String getLugardDespacho() {
		return lugardDespacho;
	}

	public void setLugardDespacho(String lugardDespacho) {
		this.lugardDespacho = lugardDespacho;
	}

	public String getNombdDespacho() {
		return nombdDespacho;
	}

	public void setNombdDespacho(String nombdDespacho) {
		this.nombdDespacho = nombdDespacho;
	}

	public String getCantidaddDespacho() {
		return cantidaddDespacho;
	}

	public void setCantidaddDespacho(String cantidaddDespacho) {
		this.cantidaddDespacho = cantidaddDespacho;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Ordendespacho getOrdendespacho() {
		return ordendespacho;
	}

	public void setOrdendespacho(Ordendespacho ordendespacho) {
		this.ordendespacho = ordendespacho;
	}

	

	
	
}
