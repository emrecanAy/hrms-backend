package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entites.concretes.City;
import kodlamaio.hrms.entites.dtos.CityAddDto;

public interface CityDao extends JpaRepository<City, Integer>{
	
	@Query("Select new kodlamaio.hrms.entites.dtos.CityAddDto(c.id, c.name, c.countryId, ct.name) "
			+ "From City c Inner Join Country ct on ct.id = c.countryId")
	public List<CityAddDto> cityAddDetails(); 
	
	
	
	//select (p.productId, p.productName, c.categoryName)
	//from Category c inner join Product p on c.categoryId = p.categoryId 
	
//	@Query("Select new kodlamaio.hrms.entites.dtos.CityDto(c.id, c.name, co.name) "
//			+ "From City c Inner Join c.country co")
//	List<CityDto> cityDetails();


}
