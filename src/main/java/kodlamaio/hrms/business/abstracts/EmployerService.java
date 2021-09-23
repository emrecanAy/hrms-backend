package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(Employer employer, String rePassword);
	Result confirmEmployer(int id);
	Result update(Employer employer);
	DataResult<Employer> getByUserId(int id);
	DataResult<List<Employer>> getByUpdatedDataNotNull();
	
}
