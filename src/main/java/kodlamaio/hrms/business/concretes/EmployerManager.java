package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.email.abstracts.EmailCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entites.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailCheckService emailCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailCheckService emailCheckService) {
		super();
		this.employerDao = employerDao;
		this.emailCheckService = emailCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data başarıyla listelendi!");
	}

	@Override
	public Result add(Employer employer) {
		// TODO Auto-generated method stub
		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAddress())) {
            return new ErrorResult("web sitesinin domaini ile email adresi uyuşmuyor");
        }
		else if (!employer.getPassword().equals(employer.getRePassword())) {
			return new ErrorResult("Girilen şifreler aynı değil!");
		}
        else if(!this.emailCheckService.checkEmailValidation(employer.getEmail())){
            return new ErrorResult("e mail onaylanmamış");
        }
        else if (!checkIfEmailExist(employer.getEmail())) {
            return new ErrorResult("Aynı e postayla başka bir kayıt var");
        }
        else {
            this.employerDao.save(employer);
            return new SuccessResult("İşlem başarılı sistem personelinin onayını bekliyor");
        }
	}


    private Boolean checkIfEqualEmailAndDomain(String email, String website) {
        String emailArr = email.split("@")[1];
        String domain = website.substring(4, website.length());

        if (emailArr.equals(domain)) {

            return true;
        }

        return false;
    }

    public Boolean checkIfEmailExist(String email) {
        if (this.employerDao.getByEmail(email)!=null) {
            return false;
        } else {
            return true;
        }
    }



	@Override
	public Result confirmEmployer(int id) {
		
		Employer employer = employerDao.getByUserId(id);
		employer.setIsConfirm(true);
		employerDao.save(employer);
		return new SuccessResult("Onaylama başarılı bir şekilde yapıldı!");
		
	}


	@Override
	public Result update(Employer employer) {
		employer.setIsConfirm(false);
		employerDao.save(employer);
		return new SuccessResult("Güncelleme başarılı (aktivasyon için onay bekleniyor)!");
	}


//	@Override
//	public Result updateConfirm(int userId) {
//		
//		Employer employer = employerDao.getByUserId(userId);
//		if(!Objects.isNull(employer.getUpdatedData())) {
//			Employer updatedData = employer.getUpdatedData();
//			employerDao.save(updatedData);
//			 return new SuccessResult("Kullanıcı onay durumu *Onaylandı* olarak değiştirildi");
//		}
//		employer.setIsActive(!employer.getIsActive()); //amaç? 
//		employerDao.save(employer);
//		return new SuccessResult("Kullanıcı onay durumu *Onaylandı* olarak değiştirildi");
//		
//	}


	@Override
	public DataResult<Employer> getByUserId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Employer>(this.employerDao.getByUserId(id), "Data başarıyla listelendi!");
	}
	
	


	@Override
	public DataResult<List<Employer>> getByUpdatedDataNotNull() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>(employerDao.getByUpdatedDataNotNull());
	}

	

}
