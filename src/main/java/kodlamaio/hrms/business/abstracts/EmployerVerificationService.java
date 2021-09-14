package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmployerVerificationService {
	
	Result verifyByEmail(int userId);
	Result verifyByAdminApproval(int userId);

}
