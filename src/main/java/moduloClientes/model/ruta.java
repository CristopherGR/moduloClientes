package moduloClientes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document (collection = "ruta")
public class ruta {
	
	@Id
	private int idRuta;
	
	@Field
	private String descripcion;

}
