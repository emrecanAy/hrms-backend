package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateEducationDao;
import kodlamaio.hrms.entites.concretes.CandidateEducation;

@Service
public class CandidateEducationManager implements CandidateEducationService{

	private CandidateEducationDao candidateEducationDao;

	@Autowired
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
		super();
		this.candidateEducationDao = candidateEducationDao;
	}

	@Override
	public DataResult<List<CandidateEducation>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.findAll(), "Data başarıyla listelendi!");
	}

	@Override
	public Result add(CandidateEducation candidateEducation) {
		// TODO Auto-generated method stub
		this.candidateEducationDao.save(candidateEducation);
		return new SuccessResult("CV'ye başarıyla eklendi!");
	}

	@Override
	public DataResult<List<CandidateEducation>> getAllByCvs_Id(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.getAllByCvs_Id(id), "Data başarıyla listelendi!");
	}

	@Override
	public DataResult<List<CandidateEducation>> getAllByCvs_OrderByGraduateDateDesc(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.getAllByCvs_OrderByGraduateDateDesc(id), "Data başarıyla listelendi!");
	}
	
	
	
	
	
}
