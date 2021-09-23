package kodlamaio.hrms.entites.dtos;

import java.util.List;

import kodlamaio.hrms.entites.concretes.Country;
import kodlamaio.hrms.entites.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {

	private int id;
	private String name;	
	private int countryId;
	private String countryName;
	private Country country;
	private List<JobAdvertisement> jobAdvertisements;
	
}
