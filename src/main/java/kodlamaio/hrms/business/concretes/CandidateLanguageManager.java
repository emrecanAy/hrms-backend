package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.entites.concretes.CandidateLanguage;

@Service
public class CandidateLanguageManager implements CandidateLanguageService{

	private CandidateLanguageDao candidateLanguageDao;

	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
		super();
		this.candidateLanguageDao = candidateLanguageDao;
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.findAll(), "Data başarıyla listelendi!");
	}

	@Override
	public Result add(CandidateLanguage candidateLanguage) {
		// TODO Auto-generated method stub
		this.candidateLanguageDao.save(candidateLanguage);
		return new SuccessResult("Başarıyla eklendi!");
	}
	
	
	
	
	
}
