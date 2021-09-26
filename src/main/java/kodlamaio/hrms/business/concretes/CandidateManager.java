package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.cloudinary.BusinessRules;
import kodlamaio.hrms.core.cloudinary.ImageService;
import kodlamaio.hrms.core.email.abstracts.EmailCheckService;
import kodlamaio.hrms.core.mernis.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entites.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private MernisCheckService mernisCheckService;
	private EmailCheckService emailCheckService;
	private ImageService imageService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisCheckService mernisCheckService, EmailCheckService emailCheckService, ImageService imageService) {
		this.mernisCheckService = mernisCheckService;
		this.emailCheckService = emailCheckService;	
		this.candidateDao = candidateDao;	
		//this.userCheckService = userCheckService;
		this.imageService = imageService;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data başarıyla listelendi!");
	}

	@Override
	public Result add(Candidate candidate, String rePassword) {
		if (!checkIfEmailExist(candidate.getEmail())) {
			return new ErrorResult(candidate.getEmail() +" : Email zaten kayıtlı!");
		}
		else if (!candidate.getPassword().equals(rePassword)) {
			return new ErrorResult("girilen şifreler aynı değil");
		}
		else if(!mernisCheckService.checkIfRealPerson(candidate)){ //fake mernis
			return new ErrorResult("Geçersiz kullanıcı!"); 
		}
		else if(!emailCheckService.checkEmailValidation(candidate.getEmail())) {
			return new ErrorResult(candidate.getEmail() +" : Email onaylanmamış!"); 
		}
		else{					
			this.candidateDao.save(candidate);
			return new SuccessResult("Kişi başarıyla eklendi!");
		}
		
	}

	@Override
	public DataResult<Candidate> getByEmail(String email) {
		if (checkIfEmailExist(email)) {
			return new SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email), "Data başarıyla listelendi!");
		}else {
			return new ErrorDataResult<Candidate>("Kullanıcı bulunamadı");
		}
	}
	
	@Override
	public Result imageUpload(int candidateId, MultipartFile file) throws IOException {
		
		var candidate = this.candidateDao.getById(candidateId);
        var imageUrl = uploadImageToCloudinary(file, candidate.getImageUrl());
        var result = BusinessRules.Run(checkCandidateHadImageUrl(imageUrl.getMessage(),candidate.getImageUrl()));

        if (!result.isSuccess()){
            return new ErrorDataResult<>(null, result.getMessage());
        }if (!imageUrl.isSuccess()){
            return new ErrorDataResult<>(null, imageUrl.getMessage());
        }
        candidate.setImageUrl(imageUrl.getMessage());
        return new SuccessDataResult<>(this.candidateDao.save(candidate));
		
	}
	
	public boolean checkIfEmailExist(String email) {
		if (this.candidateDao.getByEmail(email)!=null) {
			return false;
		}
		return true;
	}

	private Result checkCandidateHadImageUrl(String newUrl, String oldUrl){
        if(oldUrl != null && newUrl == null){
            return new ErrorResult("Image must be required");
        }
        return new SuccessResult();
    }


    private  Result uploadImageToCloudinary( MultipartFile file, String imageUrl) throws IOException {

        var result = this.imageService.upload(file);
        if(!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }
        if(imageUrl != null){
            var imageId = imageUrl.split(("/"))[imageUrl.split(("/")).length - 1].split("\\.")[0];
            this.imageService.delete(imageId);
        }
        var url = result.getData().get("url");
        return new SuccessResult(url.toString());
    }
	
	
	
	
	
	
	
}
