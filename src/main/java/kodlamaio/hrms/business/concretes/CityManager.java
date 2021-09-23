package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entites.concretes.City;
import kodlamaio.hrms.entites.dtos.CityAddDto;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	

	@Override
	//Automapper araştır!
	public Result add(CityAddDto cityAddDto) {
		// TODO Auto-generated method stub

		City city = new City();
		city.setId(cityAddDto.getId());
		city.setCountryId(cityAddDto.getCountryId());
		city.setName(cityAddDto.getName());	
		this.cityDao.save(city);
		return new SuccessResult("Başarıyla eklendi!");
	}

	@Override
	public DataResult<List<City>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Data başarıyla listelendi!");
	}


	@Override
	public DataResult<List<CityAddDto>> getDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CityAddDto>>(this.cityDao.cityAddDetails(), "Data başarıyla listelendi!");
	}
	
	

	
	
	

	
	
	
	
	
	
}
