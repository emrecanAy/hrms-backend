package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entites.concretes.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer>{

	//List<WorkExperience> getAllByCvs_Id(int id);
	//List<WorkExperience> getAllByCvs_OrderByGraduateDateDesc(int id);
	
}

