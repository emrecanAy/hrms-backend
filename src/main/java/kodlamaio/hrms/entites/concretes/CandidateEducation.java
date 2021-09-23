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
@Table(name = "candidates_education")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEducation {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity = University.class)
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name="department_id")
	private Department department;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "graduate_date")
	private LocalDate graduateDate;
	
	@OneToMany(mappedBy = "candidateEducation")
	private List<Cv> cvs;

}
