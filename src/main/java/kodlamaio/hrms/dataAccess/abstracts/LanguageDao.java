package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entites.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

	
}
