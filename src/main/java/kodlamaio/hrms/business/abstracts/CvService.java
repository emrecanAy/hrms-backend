package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.Cv;

public interface CvService {

	DataResult<List<Cv>> getAll();
	Result add(Cv cv);
	
}
