package moduloClientes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import moduloClientes.model.movimiento;


@Repository
public interface movimientoRepository extends MongoRepository<movimiento, Integer>{
	

}
