package kodlamaio.hrms.core.cloudinary;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class BusinessRules {

	public static Result Run(Result... logics){
        for(Result logic:logics){
            if(!logic.isSuccess()){
                return logic;
            }
        }
        return new SuccessResult();
    }
	
}
