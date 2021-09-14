package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entites.concretes.EmployerVerification;

public interface EmployerVerificationDao extends JpaRepository<EmployerVerification, Integer>{
	
	EmployerVerification getByUserId(int userId);

}
