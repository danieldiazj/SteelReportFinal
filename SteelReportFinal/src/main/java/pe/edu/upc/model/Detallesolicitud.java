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
@Table(name="Detallesolicitud")
public class Detallesolicitud implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idDetallesolicitud;
	

	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="cantiDetallesolicitud", nullable = false, length=90)
	private String cantiDetallesolicitud;
	
	

	@ManyToOne
	@JoinColumn(name="idSolicitudcompra", nullable=false)
	private Solicitudcompra solicitudcompra;

	@ManyToOne
	@JoinColumn(name="idProducto", nullable=false)
	private Producto producto;

	public Detallesolicitud() {
		super();
		// TODO Auto-generated constructor stub
	}

	





	public Detallesolicitud(int idDetallesolicitud, String cantiDetallesolicitud,Solicitudcompra solicitudcompra, Producto producto) {
		super();
		this.idDetallesolicitud = idDetallesolicitud;
		this.cantiDetallesolicitud = cantiDetallesolicitud;
		this.solicitudcompra = solicitudcompra;
		this.producto = producto;
	}







	public int getIdDetallesolicitud() {
		return idDetallesolicitud;
	}







	public void setIdDetallesolicitud(int idDetallesolicitud) {
		this.idDetallesolicitud = idDetallesolicitud;
	}







	public String getCantiDetallesolicitud() {
		return cantiDetallesolicitud;
	}







	public void setCantiDetallesolicitud(String cantiDetallesolicitud) {
		this.cantiDetallesolicitud = cantiDetallesolicitud;
	}







	public Solicitudcompra getSolicitudcompra() {
		return solicitudcompra;
	}







	public void setSolicitudcompra(Solicitudcompra solicitudcompra) {
		this.solicitudcompra = solicitudcompra;
	}







	public Producto getProducto() {
		return producto;
	}







	public void setProducto(Producto producto) {
		this.producto = producto;
	}







	
}
