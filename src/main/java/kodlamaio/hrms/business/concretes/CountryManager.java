package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CountryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CountryDao;
import kodlamaio.hrms.entites.concretes.Country;

@Service
public class CountryManager implements CountryService{

	private CountryDao countryDao;

	@Autowired
	public CountryManager(CountryDao countryDao) {
		super();
		this.countryDao = countryDao;
	}

	@Override
	public DataResult<List<Country>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Country>>(this.countryDao.findAll(), "Data başarıyla listelendi!");
	}

	@Override
	public Result add(Country country) {
		// TODO Auto-generated method stub
		this.countryDao.save(country);
		return new SuccessResult("Ekleme başarılı!");
	}
	
	
	
	
	
	
	
}
