package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.City;
import kodlamaio.hrms.entites.dtos.CityAddDto;

public interface CityService {

	DataResult<List<City>> getAll();
	Result add(CityAddDto cityAddDto);
	DataResult<List<CityAddDto>> getDetails();
	
}
