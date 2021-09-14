package kodlamaio.hrms.entites.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employer_verifications")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerVerification {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@Column(name="verification_date")
	private LocalDate verificationDate;
	
	@Column(name="is_approved")
	private boolean isApproved;
	
	@Column(name="approval_date")
	private LocalDate approvalDate;
	

}
