package kodlamaio.hrms.core.mernis.abstracts;

import kodlamaio.hrms.entites.concretes.Candidate;

public interface MernisCheckService {
	
	public boolean checkIfRealPerson(Candidate candidate);

}
