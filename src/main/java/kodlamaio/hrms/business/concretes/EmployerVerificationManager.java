package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerVerificationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerVerificationDao;
import kodlamaio.hrms.entites.concretes.EmployerVerification;

@Service
public class EmployerVerificationManager implements EmployerVerificationService{

	private EmployerVerificationDao employerVerificationDao;
	
	@Autowired
	public EmployerVerificationManager(EmployerVerificationDao employerVerificationDao) {
		super();
		this.employerVerificationDao = employerVerificationDao;
	}

	@Override
	public Result verifyByEmail(int userId) {
		
		if(this.employerVerificationDao.getByUserId(userId)!=null) {
			return new ErrorResult("User already validated!");
		}
		
		EmployerVerification employerVerification = new EmployerVerification();
		employerVerification.setUserId(userId);;
		employerVerification.setVerified(true);
		employerVerification.setVerificationDate(LocalDate.now());
		
		this.employerVerificationDao.save(employerVerification);
		return new SuccessResult("Email doğrulama işlemi başarılı!");
		
	}

	@Override
	public Result verifyByAdminApproval(int userId) {
		EmployerVerification employerVerification = this.employerVerificationDao.getById(userId);
		
		if(employerVerification.isVerified() == false) {
			return new ErrorResult("Henüz email'iniz doğrulanmadı!");
		}
		
		employerVerification.setApproved(true);
		employerVerification.setApprovalDate(LocalDate.now());
		
		this.employerVerificationDao.save(employerVerification);
		return new SuccessResult("Email onayı başarılı!");
	}
	
	
	
}
