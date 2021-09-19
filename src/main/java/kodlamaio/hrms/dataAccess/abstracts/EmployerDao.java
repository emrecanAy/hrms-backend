package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entites.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	Employer getByEmail(String email);
	
	@Query("From Employer where id=:id")
	Employer getByUserId(int id);
	
	@Query("From Employer where id=:id and isActive=false")
	Employer getByUserIdActivateIsFalse(int id);
	
	@Query("Select password From Employer where email=?1")
	String getPasswordByEmail(String email);
	
	List<Employer> getByUpdatedDataNotNull();
}
