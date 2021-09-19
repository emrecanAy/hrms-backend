package kodlamaio.hrms.core.email.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.email.abstracts.EmailCheckService;

@Service
public class FakeEmailAdapter implements EmailCheckService{

	@Override
	public boolean checkEmailValidation(String mail) {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
