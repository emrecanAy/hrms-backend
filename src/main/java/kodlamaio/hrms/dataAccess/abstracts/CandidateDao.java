package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entites.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	Candidate getByEmail(String email);
	Candidate getById(int id);

}
