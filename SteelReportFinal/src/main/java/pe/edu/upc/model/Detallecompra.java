package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Detallecompra")
public class Detallecompra implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idDetallecompra;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="descriDetallecompra", nullable = false, length=90)
	private String descriDetallecompra;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="cantiDetallecompra", nullable = false, length=90)
	private String cantiDetallecompra;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="preciouDetallecompra", nullable = false, length=90)
	private String preciouDetallecompra;
	
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="totalDetallecompra", nullable = false, length=90)
	private String totalDetallecompra;
	

	@ManyToOne
	@JoinColumn(name="idOrdencompra", nullable=false)
	private Ordencompra ordencompra;

	@ManyToOne
	@JoinColumn(name="idProducto", nullable=false)
	private Producto producto;

	public Detallecompra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Detallecompra(int idDetallecompra,
			 String descriDetallecompra,
			 String cantiDetallecompra,
			 String preciouDetallecompra,
			 String totalDetallecompra,
			Ordencompra ordencompra, Producto producto) {
		super();
		this.idDetallecompra = idDetallecompra;
		this.descriDetallecompra = descriDetallecompra;
		this.cantiDetallecompra = cantiDetallecompra;
		this.preciouDetallecompra = preciouDetallecompra;
		this.totalDetallecompra = totalDetallecompra;
		this.ordencompra = ordencompra;
		this.producto = producto;
	}

	public int getIdDetallecompra() {
		return idDetallecompra;
	}

	public void setIdDetallecompra(int idDetallecompra) {
		this.idDetallecompra = idDetallecompra;
	}

	public String getDescriDetallecompra() {
		return descriDetallecompra;
	}

	public void setDescriDetallecompra(String descriDetallecompra) {
		this.descriDetallecompra = descriDetallecompra;
	}

	public String getCantiDetallecompra() {
		return cantiDetallecompra;
	}

	public void setCantiDetallecompra(String cantiDetallecompra) {
		this.cantiDetallecompra = cantiDetallecompra;
	}

	public String getPreciouDetallecompra() {
		return preciouDetallecompra;
	}

	public void setPreciouDetallecompra(String preciouDetallecompra) {
		this.preciouDetallecompra = preciouDetallecompra;
	}

	public String getTotalDetallecompra() {
		return totalDetallecompra;
	}

	public void setTotalDetallecompra(String totalDetallecompra) {
		this.totalDetallecompra = totalDetallecompra;
	}

	public Ordencompra getOrdencompra() {
		return ordencompra;
	}

	public void setOrdencompra(Ordencompra ordencompra) {
		this.ordencompra = ordencompra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	
	
}
