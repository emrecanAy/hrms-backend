package kodlamaio.hrms.core.email.concretes;

import kodlamaio.hrms.core.email.abstracts.EmailCheckService;

public class FakeEmailAdapter implements EmailCheckService{

	@Override
	public boolean checkEmailValidation(String mail) {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
