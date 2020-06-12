package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.jefeVentas;
import pe.edu.upc.repository.IjefeVentasRepository;
import pe.edu.upc.service.IjefeVentasService;


@Service
public class jefeVentasServiceImpl implements IjefeVentasService {

	
	@Autowired
	private IjefeVentasRepository djefeVentas;
	
	
	
	@Override
	@Transactional
	public boolean insertar(jefeVentas jefeventas) {
		jefeVentas objjefeVentas = djefeVentas.save(jefeventas);
		if (objjefeVentas == null)
			return false;
		else 
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(jefeVentas jefeventas) {
		boolean flag = false;
		try {
			djefeVentas.save(jefeventas);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche....");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idjefeVentas) {
		djefeVentas.deleteById(idjefeVentas);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<jefeVentas> buscarId(int idjefeVentas) {
		return djefeVentas.findById(idjefeVentas);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<jefeVentas> listarId(int idjefeVentas) {
		return djefeVentas.findById(idjefeVentas);
	}

	@Override
	@Transactional
	public List<jefeVentas> listar() {
		return djefeVentas.findAll();
	}

	@Override
	@Transactional
	public List<jefeVentas> buscarNombre(String nombjefeVentas) {
		return djefeVentas.buscarNombre(nombjefeVentas);
	}

	@Override
	@Transactional
	public List<jefeVentas> buscarTipo(String nombreTipo) {
		return djefeVentas.buscarTipo(nombreTipo);
	}

	
	
}
