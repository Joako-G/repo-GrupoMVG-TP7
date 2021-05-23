package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.model.Cuenta;
import ar.edu.unju.fi.tp7.repository.ICuentaRepository;
import ar.edu.unju.fi.tp7.service.ICuentaService;

@Service("cuentaServiceMysql")
public class CuentaServiceMysqlImp implements ICuentaService {
	
	@Autowired
	private ICuentaRepository cuentaRepository;
	
	@Override
	public void guardarCuenta(Cuenta cuenta) {
		cuentaRepository.save(cuenta);
	}

	@Override
	public List<Cuenta> getCuenta() {
		List <Cuenta> cuentas = (List<Cuenta>) cuentaRepository.findAll();
		return cuentas;
	}

}