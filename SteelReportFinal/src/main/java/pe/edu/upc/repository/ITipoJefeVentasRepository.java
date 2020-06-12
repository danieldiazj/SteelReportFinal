package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.TipoJefeVentas;



@Repository
public interface ITipoJefeVentasRepository extends JpaRepository<TipoJefeVentas, Integer>{
	@Query("from TipoJefeVentas t where t.nombreTipo like %:nombreTipo%")
	List<TipoJefeVentas> buscarNombre(@Param("nombreTipo") String nombreTipo);
}


