package kodlamaio.hrms.entites.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "work_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@ManyToOne(targetEntity = JobTitle.class) //targetEntity hedef class'ı belirtmek gerekiyor yoksa bulamayıp patlıyor. Aynı şekilde diğer onetomanylerde de yazıyoruz.
	@JoinColumn(name="job_title_id")		  //bkz.https://stackoverflow.com/questions/3983135/hibernate-manytoone-references-an-unknown-entity/22706340
	private String jobTitle;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@OneToMany(mappedBy = "workExperience")
	private List<Cv> cvs;
	
	
	
	
}
