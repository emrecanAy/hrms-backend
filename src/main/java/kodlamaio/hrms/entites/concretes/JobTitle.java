package kodlamaio.hrms.entites.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="job_position")
	@NotNull
	@NotBlank
	private String jobPosition;
	
	@Column(name="description")
	private String description;
	
	@Column(name="is_active")
	@JsonIgnore
	private Boolean isActive;
	
	@Column(name="is_deleted")
	private Boolean isDeleted;
	
	@OneToMany(mappedBy = "jobTitle", targetEntity = JobAdvertisement.class)
	private List<JobAdvertisement> jobAdvertisements;
	
	@OneToMany(mappedBy = "jobTitle", targetEntity = WorkExperience.class)
	private List<WorkExperience> workExperiences;

}
