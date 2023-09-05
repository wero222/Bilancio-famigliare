package it.corso.service;
import java.util.List;
import it.corso.model.Operation;

public interface OperationService
{
	void createOperation(Operation operation);
	List<Operation> getOperations();
	Operation getOperationById(int id);
	void deleteOperation(Operation operation);
	double getBalance(List<Operation> operations);
}