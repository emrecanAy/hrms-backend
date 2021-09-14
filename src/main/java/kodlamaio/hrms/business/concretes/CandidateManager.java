package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.email.abstracts.EmailCheckService;
import kodlamaio.hrms.core.mernis.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entites.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private MernisCheckService mernisCheckService;
	private EmailCheckService emailCheckService;
	
	public CandidateManager(MernisCheckService mernisCheckService, EmailCheckService emailCheckService) {
		this.mernisCheckService = mernisCheckService;
		this.emailCheckService = emailCheckService;
	}
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;	
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data başarıyla listelendi!");
	}

	@Override
	public Result add(Candidate candidate) {
		if (checkIfEmailExist(candidate.getEmail())) {
			this.candidateDao.save(candidate);
			return new SuccessResult("Kişi başarıyla eklendi!");
		}
		else if(!mernisCheckService.checkIfRealPerson(candidate)){
			return new ErrorResult("Geçersiz kullanıcı!"); 
		}
		else if(!emailCheckService.checkEmailValidation(candidate.getEmail())) {
			return new ErrorResult(candidate.getEmail() +" : Email onaylanmamış!"); 
		}
		else{			
			return new ErrorResult(candidate.getEmail() +" : Email zaten kayıtlı!");
		}
		
	}

	@Override
	public DataResult<Candidate> getByEmail(String email) {
		if (checkIfEmailExist(email)) {
			return new SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email), "Data başarıyla listelendi!");
		} else {
			return new ErrorDataResult<Candidate>("Kullanıcı bulunamadı");
		}
	}
	
	public boolean checkIfEmailExist(String email) {
		if (this.candidateDao.getByEmail(email)!=null) {
			return false;
		}
		return true;
	}
	
	
	
	
}
