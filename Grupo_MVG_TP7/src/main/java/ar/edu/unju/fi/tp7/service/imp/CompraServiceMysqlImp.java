package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.model.Compra;
import ar.edu.unju.fi.tp7.repository.ICompraRepository;
import ar.edu.unju.fi.tp7.service.ICompraService;

@Service("compraServiceMysql")
public class CompraServiceMysqlImp implements ICompraService {
	
	@Autowired
	private ICompraRepository compraRepository;

	@Override
	public void generarTablaCompras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarCompra(Compra compra) {
		compraRepository.save(compra);
		
	}

	@Override
	public List<Compra> getCompras() {
		List<Compra> compras = (List<Compra>) compraRepository.findAll();
		return compras;
	}

	@Override
	public Compra consultarUltimaCompra() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Compra> getCompraPorId(Long id) {
		Optional<Compra> compra = compraRepository.findById(id);
		return compra;
	}
	
	@Override
	public void eliminarCompra(Long id) {
		compraRepository.deleteById(id);
	}

}
