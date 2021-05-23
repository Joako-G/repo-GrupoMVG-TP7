package ar.edu.unju.fi.tp7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp7.model.Cuenta;
import ar.edu.unju.fi.tp7.service.ICuentaService;

@Controller
public class CuentaController {
	
	
	@Autowired
	private Cuenta cuenta;
	
	@Autowired
	@Qualifier("cuentaServiceMysql")
	private ICuentaService cuentaService;
	
	@GetMapping("/cuenta/nueva")
	public String getCuentaNuevaPage(Model model) {
		model.addAttribute(cuenta);
		return "nuevacuenta";
	}
	
	@PostMapping("/cuenta/guardar")
	public ModelAndView guardarCuentaPage(@ModelAttribute("cuenta") Cuenta cuenta) {
		ModelAndView model = new ModelAndView("cuentas");
		cuentaService.guardarCuenta(cuenta);
		model.addObject("cuentas", cuentaService.getCuenta());
		return model;
	}
	
	@GetMapping("/cuenta/listado")
	public ModelAndView getListadoCuentaPage() {
		ModelAndView model = new ModelAndView("cuentas");
		model.addObject("cuentas", cuentaService.getCuenta());
		return model;
	}
}
