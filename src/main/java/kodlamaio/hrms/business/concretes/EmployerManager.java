package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entites.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data başarıyla listelendi!");
	}

	@Override
	public Result add(Employer employer) {
		if (checkIfEmailExist(employer.getEmail())) {
			this.employerDao.save(employer);
			return new SuccessResult("Kayıt işlemi başarılı!(Onay bekleniyor...)");
		}
		else{
			
			return new ErrorResult("Email zaten kayıtlı!");
		}
	}
	
	
	public boolean checkIfEmailExist(String email) {
		if (this.employerDao.getByEmail(email)!=null) {
			return false;
		}
		return true;
	}
	
}
