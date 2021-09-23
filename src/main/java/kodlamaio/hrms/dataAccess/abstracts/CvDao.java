package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entites.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{

}
