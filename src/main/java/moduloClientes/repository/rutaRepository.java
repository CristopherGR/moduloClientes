package moduloClientes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import moduloClientes.model.ruta;

@Repository
public interface rutaRepository extends MongoRepository<ruta, String> {
	

}
