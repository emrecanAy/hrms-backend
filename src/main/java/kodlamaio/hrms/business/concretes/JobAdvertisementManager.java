package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entites.concretes.JobAdvertisement;
import kodlamaio.hrms.entites.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getall() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data başarıyla listelendi!");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Başarıyla eklendi!");
	}
	
	public DataResult<List<JobAdvertisementDto>> jobAdvertisementDetails(){
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.jobAdvertisementDetails(), "Data başarıyla listelendi!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveJobs() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getActiveJobs(), "Data başarıyla listelendi!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByCreatedDate() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), "Data başarıyla listelendi!");
	
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByCompanyAndActiveJobs(String companyName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCompanyAndActiveJobs(companyName), "Data başarıyla listelendi!");
	}

	@Override
	public Result setIsActive(int id) {
		// TODO Auto-generated method stub
		JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.getById(id);
        jobAdvertisement.setIsActive(!jobAdvertisement.getIsActive());
        this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İşlem başarılı!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedJobAdvertisementByStatusDesc() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllSortedJobAdvertisementByStatusDesc(), "Data başarıyla listelendi!");
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
