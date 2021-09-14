package kodlamaio.hrms.core.mernis.concretes;

import kodlamaio.hrms.core.mernis.abstracts.MernisCheckService;
import kodlamaio.hrms.entites.concretes.Candidate;

public class FakeMernisAdapter implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
