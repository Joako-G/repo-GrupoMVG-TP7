package ar.edu.unju.fi.tp7.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp7.model.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Long> {

	public Producto findByCodigo(int codigo);
	
}
