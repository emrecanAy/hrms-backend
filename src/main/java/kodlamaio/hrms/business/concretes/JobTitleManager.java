package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entites.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if(!checkIfJobTitleExist(jobTitle.getJobPosition())) {
			return new ErrorResult(jobTitle.getJobPosition()+ " zaten kayıtlı!");
		}else {
			this.jobTitleDao.save(jobTitle);
			return new SuccessResult("Meslek başarıyla eklendi!");
		}	
	}
	
	public boolean checkIfJobTitleExist(String jobTitle) {
		if(this.jobTitleDao.getByJobTitle(jobTitle) != null) {
			return false;
		}
		return true;
	}
	
}
