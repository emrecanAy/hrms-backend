package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entites.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>{

}
