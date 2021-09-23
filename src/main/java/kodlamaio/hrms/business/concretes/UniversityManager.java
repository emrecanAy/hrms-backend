package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UniversityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UniversityDao;
import kodlamaio.hrms.entites.concretes.University;

@Service
public class UniversityManager implements UniversityService{

	private UniversityDao universityDao;
	
	@Autowired
	public UniversityManager(UniversityDao universityDao) {
		super();
		this.universityDao = universityDao;
	}

	@Override
	public Result add(University university) {
		// TODO Auto-generated method stub
		this.universityDao.save(university);
		return new SuccessResult(university.getName() + " başarıyla eklendi!");
	}

	@Override
	public DataResult<List<University>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<University>>(this.universityDao.findAll(), "Data başarıyla listelendi!");
	}
	
	
	
	
	
}
