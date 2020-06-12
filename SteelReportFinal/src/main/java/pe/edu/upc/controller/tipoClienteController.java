package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.model.tipoCliente;
import pe.edu.upc.service.ItipoClienteService;


@Controller
@RequestMapping("/tipocliente")
public class tipoClienteController {

	@Autowired
	private ItipoClienteService tService;
	
	@RequestMapping("/bienvenido")
	public String irtipoClienteBienvenido() {		
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irtipoCliente(Map<String, Object> model) {
		model.put("listatiposCliente", tService.listar());
		return "listtipoCliente";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) 
	{
		model.addAttribute("tipocliente", new tipoCliente());
		return "tipocliente";
		
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid tipoCliente objtipoCliente, BindingResult binRes, Model model)
			throws ParseException
	{
		if (binRes.hasErrors()) {
			return "tipocliente";
		}
		else {
				boolean flag = tService.insertar(objtipoCliente);
				if (flag) {
					return "redirect:/tipocliente/listar";
				}
				else {
					model.addAttribute("mensaje", "Ocurrio un problema grave :c");
					return "redirect:/tipocliente/irRegistrar";
				}
			}
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid tipoCliente objtipoCliente, BindingResult binRes, Model model,
			RedirectAttributes objRedir) throws ParseException
	{
		if (binRes.hasErrors()) {
			return "redirect:/tipocliente/listar";
		}
		else {
			boolean flag = tService.modificar(objtipoCliente);
			if (flag) {
				objRedir.addFlashAttribute("mensaje", "Se actualizo correctamente :)");
				return "redirect:/tipocliente/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/tipocliente/irRegistrar";
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
	{
		Optional<tipoCliente> objtipoCliente = tService.listarId(id);
		if (objtipoCliente == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche");
			return "redirect:/tipocliente/listar";
		}
		else {
			model.addAttribute("tipocliente", objtipoCliente);
			return "tipocliente";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id > 0) {
				tService.eliminar(id);
				model.put("listatiposCliente", tService.listar());
			}			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listatiposCliente", tService.listar());
		}
		return "listtipoCliente";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listatiposCliente", tService.listar());
		return "listtipoCliente";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute tipoCliente tipocliente) 
	throws ParseException
	{
		tService.listarId(tipocliente.getIdtipoCliente());
		return "listtipoCliente";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute tipoCliente tipocliente) 
			throws ParseException
	{
		List<tipoCliente> listatiposCliente;
		tipocliente.setNombtipoCliente(tipocliente.getNombtipoCliente());
		listatiposCliente = tService.buscarNombre(tipocliente.getNombtipoCliente());
		
		if (listatiposCliente.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("listatiposCliente", listatiposCliente);
		return "buscar";		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("tipocliente", new tipoCliente());
		return "buscar";
	}
		
}

