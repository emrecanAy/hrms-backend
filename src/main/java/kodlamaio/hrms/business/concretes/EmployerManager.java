package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.email.abstracts.EmailCheckService;
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
	private EmailCheckService emailCheckService;
	
	public EmployerManager(EmailCheckService emailCheckService) {
		super();
		this.emailCheckService = emailCheckService;
	}
	
	
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
	public Result add(Employer employer, String password) {
		if (checkIfEmailExist(employer.getEmail())) {
			this.employerDao.save(employer);
			return new SuccessResult("Kayıt işlemi başarılı!(Onay bekleniyor...)");
		}
		else if(!this.emailCheckService.checkEmailValidation(employer.getEmail())) {
			return new ErrorResult(employer.getEmail() +" : Email onaylanmamış!");
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


	@Override
	public Result confirmEmployer(int id) {
		
		Employer employer = employerDao.getByUserId(id);
		employer.setIsConfirm(true);;
		employerDao.save(employer);
		return new SuccessResult("Onaylama başarılı bir şekilde yapıldı!");
		
	}


	@Override
	public Result update(Employer employer) {
		Employer updatedUser = employerDao.getByUserId(employer.getId());
		updatedUser.setUpdatedData(employer);
		employerDao.save(updatedUser);
		return new SuccessResult("Güncelleme başarılı (aktivasyon için onay bekleniyor)");
	}


	@Override
	public Result updateConfirm(int userId) {
		
		Employer employer = employerDao.getByUserId(userId);
		if(!Objects.isNull(employer.getUpdatedData())) {
			Employer updatedData = employer.getUpdatedData();
			employerDao.save(updatedData);
			 return new SuccessResult("Kullanıcı onay durumu *Onaylandı* olarak değiştirildi");
		}
		employer.setIsActive(!employer.getIsActive());
		employerDao.save(employer);
		return new SuccessResult("Kullanıcı onay durumu *Onaylandı* olarak değiştirildi");
		
	}


	@Override
	public DataResult<Employer> getByUserId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Employer>(this.employerDao.getByUserId(id), "Data başarıyla listelendi!");
	}
	
	


	@Override
	public DataResult<List<Employer>> getByUpdatedDataNotNull() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>(employerDao.getByUpdatedDataNotNull());
	}

}
