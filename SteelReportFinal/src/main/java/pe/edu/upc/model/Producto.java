package pe.edu.upc.model;
//js
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idProducto;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="medidProducto", nullable = false, length=60)//cambio a int o float??
	private String medidProducto;
	
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="nomProducto", nullable = false, length=60)
	private String nomProducto;
	
	//LE C AMBIOE LE NOMBRE A LA TABLA NOMA
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Size(min=0, max=999999)
	@Column(name="stockProducto", nullable = false) //cambio a int
	private int stockProducto;


	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Producto(int idProducto,
			 String medidProducto,
			 String nomProducto,
			 int stockProducto) {
		super();
		this.idProducto = idProducto;
		this.medidProducto = medidProducto;
		this.nomProducto = nomProducto;
		this.stockProducto = stockProducto;
	}





	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public String getMedidProducto() {
		return medidProducto;
	}


	public void setMedidProducto(String medidProducto) {
		this.medidProducto = medidProducto;
	}


	public String getNomProducto() {
		return nomProducto;
	}


	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}





	public int getStockProducto() {
		return stockProducto;
	}





	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}


	
	

	
	
	
	
}
