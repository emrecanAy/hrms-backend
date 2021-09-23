package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entites.concretes.CandidateEducation;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation, Integer>{

	List<CandidateEducation> getAllByCvs_Id(int id);
	List<CandidateEducation> getAllByCvs_OrderByGraduateDateDesc(int id);
}
