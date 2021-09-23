package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.JobAdvertisement;
import kodlamaio.hrms.entites.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getall();
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getActiveJobs();

	DataResult<List<JobAdvertisement>> getAllSortedByCreatedDate();
	
	DataResult<List<JobAdvertisementDto>> jobAdvertisementDetails();

	DataResult<List<JobAdvertisement>> getByCompanyAndActiveJobs(String companyName);
	
	//DataResult<List<JobAdvertisement>> findIsActiveTrueByOrderByCreatedDateDesc();
	
	DataResult<List<JobAdvertisement>> getAllSortedJobAdvertisementByStatusDesc();
	
	Result setIsActive(int id);
	
	
}
