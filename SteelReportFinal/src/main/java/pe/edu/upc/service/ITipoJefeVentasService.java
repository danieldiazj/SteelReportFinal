package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.TipoJefeVentas;

public interface ITipoJefeVentasService {
	public boolean insertar(TipoJefeVentas tipojefeventas);
	public boolean modificar(TipoJefeVentas tipojefeventas);
	public void eliminar(int idTipoJefeVentas);
	public Optional<TipoJefeVentas> buscarId(int idTipoJefeVentas);
	public Optional<TipoJefeVentas> listarId(int idTipoJefeVentas);
	List<TipoJefeVentas> listar();
	List<TipoJefeVentas> buscarNombre(String nombreTipo);		
}
