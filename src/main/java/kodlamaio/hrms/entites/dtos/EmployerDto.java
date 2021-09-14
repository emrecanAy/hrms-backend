package kodlamaio.hrms.entites.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper =false)
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDto extends UserDto{
	
	private int id;
	private String companyName;
	private String webAddress;
	private String phoneNumber;
	

}
