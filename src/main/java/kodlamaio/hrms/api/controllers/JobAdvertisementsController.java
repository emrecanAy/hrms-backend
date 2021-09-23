package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.JobAdvertisement;
import kodlamaio.hrms.entites.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getall(){
		return this.jobAdvertisementService.getall();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/jobAdvertisementDetails")
	public DataResult<List<JobAdvertisementDto>> jobAdvertisementDetails(){
		return this.jobAdvertisementService.jobAdvertisementDetails();
	}
	
	@GetMapping("/getAllSortedByCreatedDate")
	public DataResult<List<JobAdvertisement>> getAllSortedByCreatedDate(){
		return this.jobAdvertisementService.getAllSortedByCreatedDate();
	}
	
	@GetMapping("/getActiveJobs")
	public DataResult<List<JobAdvertisement>> getActiveJobs(){
		return this.jobAdvertisementService.getActiveJobs();
	}
	
	@GetMapping("/getByCompanyAndActiveJobs")
	public DataResult<List<JobAdvertisement>> getByCompanyAndActiveJobs(String companyName){
		return this.jobAdvertisementService.getByCompanyAndActiveJobs(companyName);
	}
	
	@PostMapping("/getByCompanyAndActiveJobs")
	public Result setIsActive(int id) {
		return this.jobAdvertisementService.setIsActive(id);
	}
	
	@GetMapping("/getAllSortedJobAdvertisementByStatusDesc")
	public DataResult<List<JobAdvertisement>> getAllSortedJobAdvertisementByStatusDesc(){
		return this.jobAdvertisementService.getAllSortedJobAdvertisementByStatusDesc();
	}
	
	
}
