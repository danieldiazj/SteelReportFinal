package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.TipoJefeVentas;
import pe.edu.upc.repository.ITipoJefeVentasRepository;
import pe.edu.upc.service.ITipoJefeVentasService;


@Service
public class TipoJefeVentasServiceImpl implements ITipoJefeVentasService {

	@Autowired
	private ITipoJefeVentasRepository tTipoJefeVentas;
	
	@Override
	@Transactional
	public boolean insertar(TipoJefeVentas tipojefeventas) {
		TipoJefeVentas objTipoJefeVentas = tTipoJefeVentas.save(tipojefeventas);
		if (objTipoJefeVentas == null)
			return false;
		else 
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(TipoJefeVentas tipojefeventas) {
		boolean flag = false;
		try {
			tTipoJefeVentas.save(tipojefeventas);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche....");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idTipoJefeVentas) {
		tTipoJefeVentas.deleteById(idTipoJefeVentas);		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<TipoJefeVentas> listarId(int idTipoJefeVentas) {
		return tTipoJefeVentas.findById(idTipoJefeVentas);
	}

	@Override
	@Transactional
	public List<TipoJefeVentas> listar() {
		return tTipoJefeVentas.findAll();
	}

	@Override
	@Transactional
	public List<TipoJefeVentas> buscarNombre(String nombreTipo) {
		return tTipoJefeVentas.buscarNombre(nombreTipo);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<TipoJefeVentas> buscarId(int idTipoJefeVentas) {
		return tTipoJefeVentas.findById(idTipoJefeVentas);
	}

}
