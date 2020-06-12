package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.tipoCliente;

public interface ItipoClienteService {
	public boolean insertar(tipoCliente tipocliente);
	public boolean modificar(tipoCliente tipocliente);
	public void eliminar(int idtipoCliente);
	public Optional<tipoCliente> buscarId(int idtipoCliente);
	public Optional<tipoCliente> listarId(int idtipoCliente);
	List<tipoCliente> listar();
	List<tipoCliente> buscarNombre(String nombtipoCliente);		
}
