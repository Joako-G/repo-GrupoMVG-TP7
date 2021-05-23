package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.model.Cliente;
import ar.edu.unju.fi.tp7.repository.IClienteRepository;
import ar.edu.unju.fi.tp7.service.IClienteService;

@Service("clienteServiceMysql")
public class ClienteServiceMysqlImp implements IClienteService {

	@Autowired
	private Cliente cliente;
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	public void generarTablaClientes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public List<Cliente> getClientes() {
		List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
		return clientes;
	}

	@Override
	public Cliente getCliente() {
		return this.cliente;
	}

}
