package ar.edu.unju.fi.tp7.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp7.model.Compra;
import ar.edu.unju.fi.tp7.model.Producto;
import ar.edu.unju.fi.tp7.service.ICompraService;
import ar.edu.unju.fi.tp7.service.IProductoService;

@Controller
public class CompraController {

	
	@Autowired
	private Compra compra;
	
	@Autowired
	@Qualifier("compraServiceMysql")
	private ICompraService compraService;
	
	@Autowired
	@Qualifier("productoServiceMysql")
	private IProductoService productoService;
	
	@GetMapping("/compra/nueva")
	public String getCompraNuevaPage(Model model) {
		model.addAttribute("compra", compra);
		model.addAttribute("productos", productoService.getProductos());
		return "compranueva";
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView getGuardarCompraPage(@ModelAttribute("compra")Compra compra) {
		ModelAndView model = new ModelAndView("compras");
		Producto producto = productoService.getProductoPorCodigo(compra.getProducto().getCodigo());
		compra.setProducto(producto);
		compra.setTotal(compra.getCantidad()*producto.getPrecio());
		compraService.guardarCompra(compra);
		model.addObject("compras", compraService.getCompras());
		return model;
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView getListadoCompraPage() {
		ModelAndView model = new ModelAndView("compras");
		model.addObject("compras", compraService.getCompras());
		return model;
	}
	
	@GetMapping("/compra/ultima")
	public String getCompraUltimoPage(Model model) {
		model.addAttribute(compraService.consultarUltimaCompra());
		return "ultimacompra";
	}
	
	@GetMapping("/compra/editar/{id}")
	public ModelAndView modificarCompraPage(@PathVariable (value = "id")Long id) {
		ModelAndView model = new ModelAndView("compranueva");
		Optional<Compra> compra = compraService.getCompraPorId(id);
		model.addObject("compra", compra);
		model.addObject("productos", productoService.getProductos());
		return model;
	}
	
	@GetMapping("/compra/eliminar/{id}")
	public ModelAndView eliminarCompraPage(@PathVariable(value = "id")Long id) {
		ModelAndView model = new ModelAndView("redirect:/compra/listado");
		compraService.eliminarCompra(id);
		return model;
	}
}
