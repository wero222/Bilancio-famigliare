package it.corso.dao;
import org.springframework.data.repository.CrudRepository;
import it.corso.model.Operation;

public interface OperationDao extends CrudRepository<Operation, Integer>
{
	
}