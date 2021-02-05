package moduloClientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moduloClientes.exception.RecordNotFoundException;
import moduloClientes.model.cuentaCliente;
import moduloClientes.repository.cuentaClienteRepository;

@Service
public class cuentaClienteService {
	@Autowired
	private cuentaClienteRepository repository;
	
	public List<cuentaCliente> getAll(){
		List<cuentaCliente> lista = repository.findAll();
		
		if(lista.size() > 0) {
			return lista;
		} else {
			return new ArrayList<cuentaCliente>();
		}
	}
	
	public cuentaCliente findById(String numeroCuenta) throws RecordNotFoundException{
		Optional<cuentaCliente> cuenta = repository.findById(numeroCuenta);
		
		if(cuenta.isPresent()) {
			return cuenta.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public cuentaCliente newCuenta(cuentaCliente cuenta){
		return repository.save(cuenta);
	}
	
	public cuentaCliente updateCuenta(cuentaCliente cuenta) throws RecordNotFoundException {
		Optional<cuentaCliente> cuentaTemp = repository.findById(cuenta.get_id());
	
		if(cuentaTemp.isPresent()){
			return repository.save(cuenta);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public void deleteCuenta(String numeroCuenta) throws RecordNotFoundException{
		Optional<cuentaCliente> cuenta = repository.findById(numeroCuenta);
		
		if(cuenta.isPresent()) {
			repository.deleteById(numeroCuenta);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
}
