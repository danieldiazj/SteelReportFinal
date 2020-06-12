package pe.edu.upc.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.jefeVentas;

@Repository
public interface IjefeVentasRepository extends JpaRepository<jefeVentas, Integer>{
	@Query("from jefeVentas j where j.nombjefeVentas like %:nombjefeVentas%")
	List<jefeVentas> buscarNombre(@Param("nombjefeVentas") String namePet);
	
	@Query("from jefeVentas j where j.tipojefeventas.nombreTipo like %:nombreTipo%")
	List<jefeVentas> buscarTipo(@Param("nombreTipo") String nombreTipo);	
	
	
	
}
