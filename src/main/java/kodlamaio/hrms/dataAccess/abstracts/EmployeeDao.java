package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entites.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	Employee getByEmail(String email);
	
}
