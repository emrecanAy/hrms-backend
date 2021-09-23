package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entites.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{

}
