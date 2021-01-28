package moduloClientes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import moduloClientes.model.cuentaCliente;

@Repository
public interface cuentaClienteRepository extends MongoRepository<cuentaCliente, String> {
	

}
