package kodlamaio.hrms.entites.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@ManyToOne(targetEntity = Skill.class)
	@JoinColumn(name = "skill")
	private Skill skill;
	
	@ManyToOne(targetEntity = CandidateEducation.class)
	@JoinColumn(name = "candidate_education")
	private CandidateEducation candidateEducation;
	
	@ManyToOne(targetEntity = CandidateLanguage.class)
	@JoinColumn(name = "candidate_language")
	private CandidateLanguage candidateLanguage;
	
	@ManyToOne(targetEntity = WorkExperience.class)
	@JoinColumn(name = "work_experience")
	private WorkExperience workExperience;
	
	@ManyToOne(targetEntity = Image.class)
	@JoinColumn(name = "image_url")
	private Image imageUrl;
	

}
