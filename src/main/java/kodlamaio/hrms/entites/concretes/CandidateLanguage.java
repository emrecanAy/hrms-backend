package kodlamaio.hrms.entites.concretes;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidates_language")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateLanguage {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity = Language.class)
	@JoinColumn(name="language_id")
	private Language language;
	
	@Min(1)
	@Max(5)
	@Column(name="level")
	private int level;
	
	@OneToMany(mappedBy = "candidateLanguage")
	private List<Cv> cvs;

}
