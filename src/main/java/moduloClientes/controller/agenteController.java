package moduloClientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import moduloClientes.exception.RecordNotFoundException;
import moduloClientes.model.agente;
import moduloClientes.service.agenteService;

@RestController
@RequestMapping("/agentes")
public class agenteController {
	@Autowired
	private agenteService service;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<agente>> getAll() {
		List<agente> list = service.getAll();
		return new ResponseEntity<List<agente>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/agente/{id}")
	public ResponseEntity<agente> getById(@PathVariable("id") String ciAgente) throws RecordNotFoundException {
		agente entity = service.findById(ciAgente);
		return new ResponseEntity<agente>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/agente")
	public ResponseEntity<agente> newAgente(@RequestBody agente agente){
		service.newAgente(agente);
		return new ResponseEntity<agente>(agente, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/agente")
	public ResponseEntity<agente> updateCliente(@RequestBody agente agente) throws RecordNotFoundException{
		service.updateAgente(agente);
		return new ResponseEntity<agente>(agente, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/agente/{id}")
	public HttpStatus deleteCliente(@PathVariable("id") String ciAgente) throws RecordNotFoundException {
		service.deleteAgente(ciAgente);
		return HttpStatus.OK;
	}
}
