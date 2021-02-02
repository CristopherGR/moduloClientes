package moduloClientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import moduloClientes.exception.RecordNotFoundException;
import moduloClientes.model.cliente;
import moduloClientes.model.cuentaCliente;
import moduloClientes.repository.clienteRepository;
import moduloClientes.repository.cuentaClienteRepository;

@Service
public class clienteService {
	
	@Autowired
	private clienteRepository repositoryCliente;
	@Autowired
	private cuentaClienteRepository repositoryCuenta;
	
	public List<cliente> getAll(){
		List<cliente> lista = repositoryCliente.findAll();
		
		if(lista.size() > 0) {
			return lista;
		} else {
			return new ArrayList<cliente>();
		}
	}
	
	public cliente findById(String idCliente) throws RecordNotFoundException{
		Optional<cliente> cliente = repositoryCliente.findById(idCliente);
		
		if(cliente.isPresent()) {
			return cliente.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public String verificarCuenta(String idCliente) throws RecordNotFoundException{
		Optional<cliente> cliente = repositoryCliente.findById(idCliente);
		cliente temp = cliente.get();
		
		Optional<cuentaCliente> cuenta = repositoryCuenta.findById(temp.getNumeroCuenta());
		cuentaCliente temp2 = cuenta.get();
		
			if(temp2.getEstadoCuenta().equals("pendientes")){
				return "Este cliente tiene cuentas pendientes";			
			} else{
				return "Este cliente no tiene cuentas pendientes";
			}
	}
	
	public cliente newCliente(cliente cliente){
		return repositoryCliente.save(cliente);
	}
	
	public cliente updateCliente(cliente cliente) throws RecordNotFoundException {
		Optional<cliente> clienteTemp = repositoryCliente.findById(cliente.getIdCliente());
	
		if(clienteTemp.isPresent()){
			return repositoryCliente.save(cliente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public void deleteCliente(String idCliente) throws RecordNotFoundException{
		Optional<cliente> cliente = repositoryCliente.findById(idCliente);
		
		if(cliente.isPresent()) {
			repositoryCliente.deleteById(idCliente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
		


}
