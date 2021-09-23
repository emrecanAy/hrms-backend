package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.CandidateEducation;

public interface CandidateEducationService {

	DataResult<List<CandidateEducation>> getAll();
	Result add(CandidateEducation candidateEducation);
	
}
