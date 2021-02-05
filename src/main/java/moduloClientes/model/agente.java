package moduloClientes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document (collection = "agente")
public class agente {
	
	@Id
	private String id;
	
	@Field
	private String ciAgente;
	
	@Field
	private String nombre;
	
	@Field
	private String apellido;
	
	@Field
	private String estado;
	
	@Field
	private String telefono;
	
	@Field
	private String correo;

}
