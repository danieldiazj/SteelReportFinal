package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.tipoCliente;
import pe.edu.upc.repository.ItipoClienteRepository;
import pe.edu.upc.service.ItipoClienteService;


@Service
public class tipoClienteServiceImpl implements ItipoClienteService {

	@Autowired
	private ItipoClienteRepository ttipoCliente;
	
	@Override
	@Transactional
	public boolean insertar(tipoCliente tipocliente) {
		tipoCliente objtipoCliente = ttipoCliente.save(tipocliente);
		if (objtipoCliente == null)
			return false;
		else 
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(tipoCliente tipocliente) {
		boolean flag = false;
		try {
			ttipoCliente.save(tipocliente);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche....");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idtipoCliente) {
		ttipoCliente.deleteById(idtipoCliente);		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<tipoCliente> listarId(int idtipoCliente) {
		return ttipoCliente.findById(idtipoCliente);
	}

	@Override
	@Transactional
	public List<tipoCliente> listar() {
		return ttipoCliente.findAll();
	}

	@Override
	@Transactional
	public List<tipoCliente> buscarNombre(String nombtipoCliente) {
		return ttipoCliente.buscarNombre(nombtipoCliente);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<tipoCliente> buscarId(int idtipoCliente) {
		return ttipoCliente.findById(idtipoCliente);
	}

}
