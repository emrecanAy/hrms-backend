package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entites.concretes.Cv;

@Service
public class CvManager implements CvService{

	private CvDao cvDao;

	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Data başarıyla listelendi!");
	}

	@Override
	public Result add(Cv cv) {
		// TODO Auto-generated method stub
		this.cvDao.save(cv);
		return new SuccessResult("Başarıyla eklendi!");
	}
	
	
	
	
}
