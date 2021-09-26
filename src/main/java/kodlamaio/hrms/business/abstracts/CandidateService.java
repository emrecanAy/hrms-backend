package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate, String rePassword);
	DataResult<Candidate> getByEmail(String email);	
	Result imageUpload(int candidateId, MultipartFile file) throws IOException;

}
