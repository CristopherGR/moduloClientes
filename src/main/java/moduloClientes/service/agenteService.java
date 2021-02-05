package moduloClientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moduloClientes.exception.RecordNotFoundException;
import moduloClientes.model.agente;
import moduloClientes.repository.agenteRepository;

@Service
public class agenteService {
	@Autowired
	private agenteRepository repository;
	
	public List<agente> getAll(){
		List<agente> lista = repository.findAll();
		
		if(lista.size() > 0) {
			return lista;
		} else {
			return new ArrayList<agente>();
		}
	}
	
	public agente findById(String ciAgente) throws RecordNotFoundException{
		Optional<agente> agente = repository.findById(ciAgente);
		
		if(agente.isPresent()) {
			return agente.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public agente newAgente(agente agente){
		return repository.save(agente);
	}
	
	public agente updateAgente(agente agente) throws RecordNotFoundException {
		Optional<agente> agenteTemp = repository.findById(agente.get_id());
	
		if(agenteTemp.isPresent()){
			return repository.save(agente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public void deleteAgente(String ciAgente) throws RecordNotFoundException{
		Optional<agente> agente = repository.findById(ciAgente);
		
		if(agente.isPresent()) {
			repository.deleteById(ciAgente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
}
