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

import pe.edu.upc.service.ITipoJefeVentasService;
import pe.edu.upc.service.IjefeVentasService;

import pe.edu.upc.model.TipoJefeVentas;
import pe.edu.upc.model.jefeVentas;

@Controller
@RequestMapping("/jefeventas")
public class jefeVentasController {

	@Autowired
	private ITipoJefeVentasService tService;
	
	@Autowired
	private IjefeVentasService jService;	
	
	@RequestMapping("/")
	public String irjefeVentas(Map<String, Object> model) {
		model.put("listaJefesV", jService.listar());
		return "listJefesVs";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) 
	{

		model.addAttribute("listatipojefes", tService.listar());
		model.addAttribute("tipojefe", new TipoJefeVentas());
		model.addAttribute("jefeventas", new jefeVentas());
		return "jefeventas";		
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid jefeVentas objjefeVentas, BindingResult binRes, Model model)
			throws ParseException
	{
		if (binRes.hasErrors()) {
			model.addAttribute("listatipojefes", tService.listar());			
			return "jefeventas";
		}
		else {
				boolean flag = jService.insertar(objjefeVentas);
				if (flag) {
					return "redirect:/jefeventas/listar";
				}
				else {
					model.addAttribute("mensaje", "Ocurrio un roche");
					return "redirect:/jefeventas/irRegistrar";
				}
			}
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid jefeVentas objjefeVentas, BindingResult binRes, Model model,
			RedirectAttributes objRedir) throws ParseException
	{
		if (binRes.hasErrors()) {
			return "redirect:/jefeVentas/listar";
		}
		else {
			boolean flag = jService.modificar(objjefeVentas);
			if (flag) {
				objRedir.addFlashAttribute("mensaje", "Se actualizo correctamente");
				return "redirect:/jefeVentas/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/jefeVentas/irRegistrar";
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
	{
		Optional<jefeVentas> objjefeVentas = jService.listarId(id);
		if (objjefeVentas == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche");
			return "redirect:/jefeventas/listar";
		}
		else {
		
			model.addAttribute("listatipojefes", tService.listar());		
			
			if (objjefeVentas.isPresent())
				objjefeVentas.ifPresent(o -> model.addAttribute("jefeventas", o));						
			return "jefeventas";
		}
	}
	// HASTA ACA VERIFICAR
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id > 0) {
				jService.eliminar(id);
				model.put("listaJefesV", jService.listar());
			}			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaJefesV", jService.listar());
		}
		return "listJefesVs";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaJefesV", jService.listar());
		return "listJefesVs";
	}
	
	
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute jefeVentas jefeventas) 
	throws ParseException
	{
		jService.listarId(jefeventas.getIdjefeVentas());
		return "listJefesVs";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute jefeVentas jefeventas) 
			throws ParseException
	{
		List<jefeVentas> listaJefesV;
		jefeventas.setNombjefeVentas(jefeventas.getNombjefeVentas());
		listaJefesV = jService.buscarNombre(jefeventas.getNombjefeVentas());
		
		if (listaJefesV.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("listaJefesV", listaJefesV);
		return "buscar";		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("jefeventas", new jefeVentas());
		return "buscar";
	}
		
}

