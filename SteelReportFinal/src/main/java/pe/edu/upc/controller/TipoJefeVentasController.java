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

import pe.edu.upc.model.TipoJefeVentas;
import pe.edu.upc.service.ITipoJefeVentasService;


@Controller
@RequestMapping("/tipojefeventas")
public class TipoJefeVentasController {

	@Autowired
	private ITipoJefeVentasService tService;
	
	@RequestMapping("/bienvenido")
	public String irTipoJefeVentasBienvenido() {		
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irTipoJefeVentas(Map<String, Object> model) {
		model.put("listaTiposJefeVentas", tService.listar());
		return "listTipoJefeVentas";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) 
	{
		model.addAttribute("tipojefeventas", new TipoJefeVentas());
		return "tipojefeventas";
		
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid TipoJefeVentas objTipoJefeVentas, BindingResult binRes, Model model)
			throws ParseException
	{
		if (binRes.hasErrors()) {
			return "tipojefeventas";
		}
		else {
				boolean flag = tService.insertar(objTipoJefeVentas);
				if (flag) {
					return "redirect:/tipojefeventas/listar";
				}
				else {
					model.addAttribute("mensaje", "Ocurrio un roche");
					return "redirect:/tipojefeventas/irRegistrar";
				}
			}
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid TipoJefeVentas objTipoJefeVentas, BindingResult binRes, Model model,
			RedirectAttributes objRedir) throws ParseException
	{
		if (binRes.hasErrors()) {
			return "redirect:/tipojefeventas/listar";
		}
		else {
			boolean flag = tService.modificar(objTipoJefeVentas);
			if (flag) {
				objRedir.addFlashAttribute("mensaje", "Se actualizo correctamente :)");
				return "redirect:/tipojefeventas/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/tipojefeventas/irRegistrar";
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
	{
		Optional<TipoJefeVentas> objTipoJefeVentas = tService.listarId(id);
		if (objTipoJefeVentas == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche");
			return "redirect:/tipojefeventas/listar";
		}
		else {
			model.addAttribute("tipojefeventas", objTipoJefeVentas);
			return "tipojefeventas";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id > 0) {
				tService.eliminar(id);
				model.put("listaTiposJefeVentas", tService.listar());
			}			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaTiposJefeVentas", tService.listar());
		}
		return "listTipoJefeVentas";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTiposJefeVentas", tService.listar());
		return "listTipoJefeVentas";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute TipoJefeVentas tipojefeventas) 
	throws ParseException
	{
		tService.listarId(tipojefeventas.getIdTipoJefeVentas());
		return "listTipoJefeVentas";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute TipoJefeVentas tipojefeventas) 
			throws ParseException
	{
		List<TipoJefeVentas> listaTiposJefeVentas;
		tipojefeventas.setNombreTipo(tipojefeventas.getNombreTipo());
		listaTiposJefeVentas = tService.buscarNombre(tipojefeventas.getNombreTipo());
		
		if (listaTiposJefeVentas.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("listaTiposJefeVentas", listaTiposJefeVentas);
		return "buscar";		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("tipojefeventas", new TipoJefeVentas());
		return "buscar";
	}
		
}

