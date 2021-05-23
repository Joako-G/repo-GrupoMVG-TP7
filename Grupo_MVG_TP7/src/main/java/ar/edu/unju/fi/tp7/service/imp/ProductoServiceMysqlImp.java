package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.model.Producto;
import ar.edu.unju.fi.tp7.repository.IProductoRepository;
import ar.edu.unju.fi.tp7.service.IProductoService;

@Service("productoServiceMysql")
public class ProductoServiceMysqlImp implements IProductoService{
	
	@Autowired
	private Producto producto;

	@Autowired
	private IProductoRepository productoRepository;
	
	@Override
	public void generarTablaProductos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarProducto(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public List<Producto> getProductos() {
		List<Producto> productos = (List<Producto>) productoRepository.findAll();
		return productos;
	}

	@Override
	public Producto consultarUltimo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto getProductoPorCodigo(int codigo) {
		Producto producto = productoRepository.findByCodigo(codigo);
		return producto;
	}

}
