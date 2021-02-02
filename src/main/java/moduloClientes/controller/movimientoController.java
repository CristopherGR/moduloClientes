package moduloClientes.controller;

import java.util.List;

import moduloClientes.exception.RecordNotFoundException;
import moduloClientes.model.movimiento;
import moduloClientes.service.movimientoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class movimientoController {
	
	@Autowired
	private movimientoService service;
	
	
	@GetMapping("/movimientos")
	public ResponseEntity<List<movimiento>> getAll() {
		List<movimiento> list = service.getAll();
		return new ResponseEntity<List<movimiento>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/movimiento/{id}")
	public ResponseEntity<movimiento> getMovimientoById(@PathVariable("id") String idMovimiento) throws RecordNotFoundException {
		movimiento entity = service.findById(idMovimiento);
		return new ResponseEntity<movimiento>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/movimiento")
	public ResponseEntity<movimiento> newMovimiento(@RequestBody movimiento movimiento){
		service.newMovimiento(movimiento);
		return new ResponseEntity<movimiento>(movimiento, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/movimiento")
	public ResponseEntity<movimiento> updateMovimiento(@RequestBody movimiento movimiento) throws RecordNotFoundException{
		service.updateMovimiento(movimiento);
		return new ResponseEntity<movimiento>(movimiento, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/movimiento/{id}")
	public HttpStatus deleteMovimiento(@PathVariable("id") String idMovimiento) throws RecordNotFoundException {
		service.deleteMovimiento(idMovimiento);
		return HttpStatus.OK;
	}
}
