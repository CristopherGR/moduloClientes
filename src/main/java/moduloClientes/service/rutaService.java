package moduloClientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moduloClientes.exception.RecordNotFoundException;
import moduloClientes.model.ruta;
import moduloClientes.repository.rutaRepository;

@Service
public class rutaService {
	
	@Autowired
	private rutaRepository repository;
	
	public List<ruta> getAll(){
		List<ruta> lista = repository.findAll();/*
		
		if(lista.size() > 0) {
			return lista;
		} else {
			return new ArrayList<ruta>();
		}*/
		return lista;
	}
	
	public ruta findById(String idRuta) throws RecordNotFoundException{
		Optional<ruta> ruta = repository.findById(idRuta);
		
		if(ruta.isPresent()) {
			return ruta.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public ruta newRuta(ruta ruta){
		return repository.save(ruta);
	}
	
	public ruta updateRuta(ruta ruta) throws RecordNotFoundException {
		Optional<ruta> rutaTemp = repository.findById(ruta.getIdRuta());
	
		if(rutaTemp.isPresent()){
			return repository.save(ruta);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public void deleteRuta(String idRuta) throws RecordNotFoundException{
		Optional<ruta> ruta = repository.findById(idRuta);
		
		if(ruta.isPresent()) {
			repository.deleteById(idRuta);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
}
