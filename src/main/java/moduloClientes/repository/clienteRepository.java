package moduloClientes.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import moduloClientes.model.cliente;

@Repository
public interface clienteRepository extends MongoRepository<cliente, String> {
	

}
