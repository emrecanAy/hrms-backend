package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entites.concretes.JobAdvertisement;
import kodlamaio.hrms.entites.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	JobAdvertisement getById(int id);

	@Query("Select new kodlamaio.hrms.entites.dtos.JobAdvertisementDto(ja.id, e.companyName, j.jobPosition, ja.openPositionCount, ja.createdDate, ja.applicationDeadline)"
			+ "From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.jobTitle j")
	List<JobAdvertisementDto> jobAdvertisementDetails(); 
	
	@Query("From JobAdvertisement WHERE isActive=true")
	List<JobAdvertisement> getActiveJobs();
	
	@Query("From JobAdvertisement WHERE employer.companyName=:companyName AND isActive=true")
	List<JobAdvertisement> getByCompanyAndActiveJobs(String companyName);
	
	

}
