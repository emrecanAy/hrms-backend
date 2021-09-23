package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entites.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;

	@Autowired
	public ImageManager(ImageDao imageDao) {
		super();
		this.imageDao = imageDao;
	}

	@Override
	public Result add(Image image) {
		// TODO Auto-generated method stub
		this.imageDao.save(image);
		return new SuccessResult("Başarıyla eklendi!");
	}

	@Override
	public DataResult<List<Image>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), "Data başarıyla listelendi!");
	}
	
	
	
	
	
}