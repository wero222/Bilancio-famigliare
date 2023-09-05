package it.corso.service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.OperationDao;
import it.corso.model.Operation;

@Service
public class OperationServiceImpl implements OperationService
{
	@Autowired
	private OperationDao operationDao;
	
	@Override
	public void createOperation(Operation operation)
	{
		operationDao.save(operation);
	}
	
	@Override
	public List<Operation> getOperations()
	{
		List<Operation> operations = (List<Operation>) operationDao.findAll();
		Comparator<Operation> byDate = Comparator.comparing(Operation::getDate).reversed();
		operations = operations
				.stream()
				.sorted(byDate)
				.collect(Collectors.toList());
		return operations;
	}
	
	@Override
	public Operation getOperationById(int id)
	{
		return operationDao.findById(id).get();
	}
	
	@Override
	public void deleteOperation(Operation operation)
	{
		operationDao.delete(operation);
	}

	@Override
	public double getBalance(List<Operation> operations)
	{
		return operations
				.stream()
				.mapToDouble(o -> o.getAmount())
				.reduce(0.0, (o1, o2) -> o1 + o2);
	}
}