package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Producto;

public interface IProductoService {
	public boolean insertar(Producto producto);
	public boolean modificar(Producto producto);
	public void eliminar(int idProducto);
	public Optional<Producto> listarId(int idProducto);
	List<Producto> listar();
	List<Producto> buscarNombre(String nomProducto);		
}
