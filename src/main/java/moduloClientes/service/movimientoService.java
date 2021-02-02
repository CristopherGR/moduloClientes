package moduloClientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moduloClientes.exception.RecordNotFoundException;
import moduloClientes.model.movimiento;
import moduloClientes.repository.movimientoRepository;

@Service
public class movimientoService {
	
	@Autowired
	private movimientoRepository repository;
	
	public List<movimiento> getAll(){
		List<movimiento> lista = repository.findAll();
		
		if(lista.size() > 0) {
			return lista;
		} else {
			return new ArrayList<movimiento>();
		}
	}
	
	public movimiento findById(String idMovimiento) throws RecordNotFoundException{
		Optional<movimiento> movimiento = repository.findById(idMovimiento);
		
		if(movimiento.isPresent()) {
			return movimiento.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public movimiento newMovimiento(movimiento movimiento){
		return repository.save(movimiento);
	}
	
	public movimiento updateMovimiento(movimiento movimiento) throws RecordNotFoundException {
		Optional<movimiento> movimientoTemp = repository.findById(movimiento.getIdMovimiento());
	
		if(movimientoTemp.isPresent()){
			return repository.save(movimiento);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public void deleteMovimiento(String idMovimiento) throws RecordNotFoundException{
		Optional<movimiento> movimiento = repository.findById(idMovimiento);
		
		if(movimiento.isPresent()) {
			repository.deleteById(idMovimiento);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

}
