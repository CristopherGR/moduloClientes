package moduloClientes.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document (collection = "movimiento")
public class movimiento {
	
	@Id
	private String _id;
	
	@Field
	private String numeroCuenta;
	
	@Field
	private String descripcion;
	
	@Field
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date fecha = new Date();
	
	@Field
	private String estado;
	
	@Field
	private Double valor;
	
	@Field
	private Double porCobrar;

}
