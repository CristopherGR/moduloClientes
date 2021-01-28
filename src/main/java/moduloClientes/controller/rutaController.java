package moduloClientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import moduloClientes.exception.RecordNotFoundException;
import moduloClientes.model.ruta;
import moduloClientes.service.rutaService;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class rutaController {
	
	@Autowired
	private rutaService service;
	
	
/*	@GetMapping("/ruta")
	public ResponseEntity<List<ruta>> getAll() {
		List<ruta> list = service.getAll();
		return new ResponseEntity<List<ruta>>(list, new HttpHeaders(), HttpStatus.OK);
	}*/
	@GetMapping("/ruta")
	public List<ruta> getAll() {
		return service.getAll();
	}

	@GetMapping("/ruta/{id}")
	public ResponseEntity<ruta> findById(@PathVariable("id") int idRuta) throws RecordNotFoundException {
		ruta entity = service.findById(idRuta);
		return new ResponseEntity<ruta>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ruta")
	public ResponseEntity<ruta> newRuta(@RequestBody ruta ruta){
		service.newRuta(ruta);
		return new ResponseEntity<ruta>(ruta, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/ruta")
	public ResponseEntity<ruta> updateRuta(@RequestBody ruta ruta) throws RecordNotFoundException{
		service.updateRuta(ruta);
		return new ResponseEntity<ruta>(ruta, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/ruta/{id}")
	public HttpStatus deleteRuta(@PathVariable("id") int idRuta) throws RecordNotFoundException {
		service.deleteRuta(idRuta);
		return HttpStatus.OK;
	}
}
