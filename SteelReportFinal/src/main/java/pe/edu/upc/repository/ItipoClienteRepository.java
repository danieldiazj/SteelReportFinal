package pe.edu.upc.repository;
//js
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.tipoCliente;



@Repository
public interface ItipoClienteRepository extends JpaRepository<tipoCliente, Integer>{
	@Query("from tipoCliente t where t.nombtipoCliente like %:nombtipoCliente%")
	List<tipoCliente> buscarNombre(@Param("nombtipoCliente") String nombtipoCliente);
}


