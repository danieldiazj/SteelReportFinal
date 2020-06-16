package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Detallesolicitud;
import pe.edu.upc.repository.IDetallesolicitudRepository;
import pe.edu.upc.service.IDetallesolicitudService;

@Service
public class DetallesolicitudServiceImpl implements IDetallesolicitudService {

	@Autowired
	private IDetallesolicitudRepository dDetallesolicitud;
	
	@Override
	@Transactional
	public boolean insertar(Detallesolicitud detallesolicitud) {
		Detallesolicitud objDetallesolicitud = dDetallesolicitud.save(detallesolicitud);
		if (objDetallesolicitud == null)
			return false;
		else 
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Detallesolicitud detallesolicitud) {
		boolean flag = false;
		try {
			dDetallesolicitud.save(detallesolicitud);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche....");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idDetallesolicitud) {
		dDetallesolicitud.deleteById(idDetallesolicitud);		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<Detallesolicitud> buscarId(int idDetallesolicitud) {
		return dDetallesolicitud.findById(idDetallesolicitud);
	}	

	@Override
	@Transactional(readOnly=true)
	public Optional<Detallesolicitud> listarId(int idDetallesolicitud) {
		return dDetallesolicitud.findById(idDetallesolicitud);
	}

	@Override
	@Transactional
	public List<Detallesolicitud> listar() {
		return dDetallesolicitud.findAll();
	}

	@Override
	@Transactional
	public List<Detallesolicitud> buscarCantidad(String cantiDetallesolicitud) {
		return dDetallesolicitud.buscarCantidad(cantiDetallesolicitud);
	}
	
	@Override
	@Transactional
	public List<Detallesolicitud> buscarProducto(String nomProducto) {
		return dDetallesolicitud.buscarProducto(nomProducto);
	}
	
	@Override
	@Transactional
	public List<Detallesolicitud> buscarSolicitudcompra(int idSolicitudcompra) {
		return dDetallesolicitud.buscarSolicitudcompra(idSolicitudcompra);
	}

	
	
}
