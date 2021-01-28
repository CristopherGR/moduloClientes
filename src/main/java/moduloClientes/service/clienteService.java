package moduloClientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import moduloClientes.exception.RecordNotFoundException;
import moduloClientes.model.cliente;
import moduloClientes.repository.clienteRepository;

@Service
public class clienteService {
	
	@Autowired
	private clienteRepository repository;
	
	public List<cliente> getAll(){
		List<cliente> lista = repository.findAll();
		
		if(lista.size() > 0) {
			return lista;
		} else {
			return new ArrayList<cliente>();
		}
	}
	
	public cliente findById(String idCliente) throws RecordNotFoundException{
		Optional<cliente> anticipo = repository.findById(idCliente);
		
		if(anticipo.isPresent()) {
			return anticipo.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public cliente newCliente(cliente cliente){
		return repository.save(cliente);
	}
	
	public cliente updateCliente(cliente cliente) throws RecordNotFoundException {
		Optional<cliente> clienteTemp = repository.findById(cliente.getIdCliente());
	
		if(clienteTemp.isPresent()){
			return repository.save(cliente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public void deleteCliente(String idCliente) throws RecordNotFoundException{
		Optional<cliente> cliente = repository.findById(idCliente);
		
		if(cliente.isPresent()) {
			repository.deleteById(idCliente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

}
