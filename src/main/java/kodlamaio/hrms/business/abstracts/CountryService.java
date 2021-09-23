package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.Country;

public interface CountryService {

	DataResult<List<Country>> getAll();
	Result add(Country country);
	
}
