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
@Table(name="jefeVentas")
public class jefeVentas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idPet;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name="namePet", nullable = false, length=60)
	private String namePet;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que NO existe")
	@Temporal(TemporalType.DATE)
	@Column(name="birthDatePet")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDatePet;

	@ManyToOne
	@JoinColumn(name="idRace", nullable=false)
	private Race race;

	@ManyToOne
	@JoinColumn(name="idDueno", nullable=false)
	private Dueno dueno;

	public jefeVentas() {
		super();
	}

	public jefeVentas(int idPet,
			String namePet,
			Date birthDatePet, Race race,
			Dueno dueno) {
		super();
		this.idPet = idPet;
		this.namePet = namePet;
		this.birthDatePet = birthDatePet;
		this.race = race;
		this.dueno = dueno;
	}

	public int getIdPet() {
		return idPet;
	}

	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}

	public String getNamePet() {
		return namePet;
	}

	public void setNamePet(String namePet) {
		this.namePet = namePet;
	}

	public Date getBirthDatePet() {
		return birthDatePet;
	}

	public void setBirthDatePet(Date birthDatePet) {
		this.birthDatePet = birthDatePet;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}
	
}
