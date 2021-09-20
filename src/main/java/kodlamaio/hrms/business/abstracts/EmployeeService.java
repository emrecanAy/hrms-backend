package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.Employee;

public interface EmployeeService {

	DataResult<List<Employee>> getAll();
	DataResult<Employee> getByEmail(String email);
	Result add(Employee employee);
	
}
