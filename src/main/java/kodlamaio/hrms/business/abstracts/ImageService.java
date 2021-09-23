package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.Image;

public interface ImageService {
	
	Result add(Image image);
	DataResult<List<Image>> getAll();

}
