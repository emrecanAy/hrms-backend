package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerVerificationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.Employee;

@RestController
@RequestMapping("/api/employerVerifications")
public class EmployerVerificationsController {

	private EmployerVerificationService employerVerificationService;

	@Autowired
	public EmployerVerificationsController(EmployerVerificationService employerVerificationService) {
		super();
		this.employerVerificationService = employerVerificationService;
	}
	
	@PostMapping("/verifyByAdmin")
	public Result verifyByAdmin(@RequestParam int userId, @RequestBody Employee employee) {
		
		if(employee.getFirstName().equals("emrecan")) {
			return this.employerVerificationService.verifyByAdminApproval(userId);
		}
		return new ErrorResult("Email doğrulaması için yetkiniz yok!");
		
	}
	
	
	
	
}
