package kodlamaio.hrms.entites.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityAddDto {
	
	private int id;
	private String name;
	private int countryId;
	private String countryName;
	

}
