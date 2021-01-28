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
import moduloClientes.model.cliente;
import moduloClientes.service.clienteService;

@RestController
@RequestMapping("/api")
public class clienteController {
	
	@Autowired
	private clienteService service;

	@GetMapping("/clientes")
	public ResponseEntity<List<cliente>> getAll() {
		List<cliente> list = service.getAll();
		return new ResponseEntity<List<cliente>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/cliente/{id}")
	public ResponseEntity<cliente> getClienteById(@PathVariable("id") String idCliente) throws RecordNotFoundException {
		cliente entity = service.findById(idCliente);
		return new ResponseEntity<cliente>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/cliente")
	public ResponseEntity<cliente> newCliente(@RequestBody cliente cliente){
		service.newCliente(cliente);
		return new ResponseEntity<cliente>(cliente, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/cliente")
	public ResponseEntity<cliente> updateCliente(@RequestBody cliente cliente) throws RecordNotFoundException{
		service.updateCliente(cliente);
		return new ResponseEntity<cliente>(cliente, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/cliente/{id}")
	public HttpStatus deleteClienteById(@PathVariable("id") String idCliente) throws RecordNotFoundException {
		service.deleteCliente(idCliente);
		return HttpStatus.OK;
	}
}
