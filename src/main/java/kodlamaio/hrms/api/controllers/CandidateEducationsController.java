package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.CandidateEducation;

@RestController
@RequestMapping("/api/candidateEducations")
public class CandidateEducationsController {

	private CandidateEducationService candidateEducationService;

	@Autowired
	public CandidateEducationsController(CandidateEducationService candidateEducationService) {
		super();
		this.candidateEducationService = candidateEducationService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateEducation>> getAll(){
		return this.candidateEducationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateEducation candidateEducation) {
		return this.candidateEducationService.add(candidateEducation);
	}
	
	@GetMapping("/getAllByCvId")
	public DataResult<List<CandidateEducation>> getAllByCvs_Id(int id){
		return this.candidateEducationService.getAllByCvs_Id(id);
	}
	
	@GetMapping("/getAllByGraduateDateDesc")
	public DataResult<List<CandidateEducation>> getAllByCvs_OrderByGraduateDateDesc(int id){
		return this.candidateEducationService.getAllByCvs_OrderByGraduateDateDesc(id);
	}
	
	
	
}
