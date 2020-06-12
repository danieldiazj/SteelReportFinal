package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.jefeVentas;

public interface IjefeVentasService {	
	public boolean insertar(jefeVentas jefeventas);
	public boolean modificar(jefeVentas jefeventas);
	public void eliminar(int idjefeVentas);
	public Optional<jefeVentas> buscarId(int idjefeVentas);
	public Optional<jefeVentas> listarId(int idjefeVentas);
	List<jefeVentas> listar();
	List<jefeVentas> buscarNombre(String nombjefeVentas);
	List<jefeVentas> buscarTipo(String nombreTipo);
}
