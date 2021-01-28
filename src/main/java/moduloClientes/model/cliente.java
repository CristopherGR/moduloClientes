package moduloClientes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document (collection = "cliente")
public class cliente {
	
	@Id
	private String idCliente;
	
	@Field
	private String tipoCliente;
	
	@Field
	private String ciAgenteVendedor;
	
	@Field
	private String numeroCuenta;
	
	@Field
	private Double montoMaximo;

	@Field
	private int diasPlazo;
	
	@Field
	private String diaVisita;
	
	@Field
	private String nombre;
	
	@Field
	private String apellido;
	
	@Field
	private String direccion;
	
	@Field
	private String telefono;
	
	@Field
	private String correo;
	
}
