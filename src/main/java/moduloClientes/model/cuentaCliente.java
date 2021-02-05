package moduloClientes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document (collection = "cuentaCliente")
public class cuentaCliente {
	
	@Id
	private String _id;
	
	@Field
	private Double saldoTotal;
	
	@Field
	private String estadoCuenta;
}
