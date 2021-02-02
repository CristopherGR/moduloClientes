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
import moduloClientes.model.cuentaCliente;
import moduloClientes.service.cuentaClienteService;

@RestController
@RequestMapping("/api")
public class cuentaClienteController {
	@Autowired
	private cuentaClienteService service;
	
	@GetMapping("/cuentas")
	public ResponseEntity<List<cuentaCliente>> getAll() {
		List<cuentaCliente> list = service.getAll();
		return new ResponseEntity<List<cuentaCliente>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/cuenta/{id}")
	public ResponseEntity<cuentaCliente> finById(@PathVariable("id") String numeroCuenta) throws RecordNotFoundException {
		cuentaCliente entity = service.findById(numeroCuenta);
		return new ResponseEntity<cuentaCliente>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/cuenta")
	public ResponseEntity<cuentaCliente> createCuenta(@RequestBody cuentaCliente cuenta){
		service.newCuenta(cuenta);
		return new ResponseEntity<cuentaCliente>(cuenta, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/cuenta")
	public ResponseEntity<cuentaCliente> updateCuenta(@RequestBody cuentaCliente cuenta) throws RecordNotFoundException{
		service.updateCuenta(cuenta);
		return new ResponseEntity<cuentaCliente>(cuenta, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/cuenta/{id}")
	public HttpStatus deleteCuentaByNumero(@PathVariable("id") String cuenta) throws RecordNotFoundException {
		service.deleteCuenta(cuenta);
		return HttpStatus.OK;
	}
}
