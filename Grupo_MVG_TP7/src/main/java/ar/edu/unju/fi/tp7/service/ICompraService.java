package ar.edu.unju.fi.tp7.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp7.model.Compra;

public interface ICompraService {
	
	public void generarTablaCompras();
	public void guardarCompra(Compra compra);
	public List<Compra> getCompras();
	public Compra consultarUltimaCompra();
	public Optional<Compra> getCompraPorId(Long id);
	public void eliminarCompra(Long id);
	
}
