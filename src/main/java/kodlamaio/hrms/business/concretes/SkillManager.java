package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entites.concretes.Skill;

@Service
public class SkillManager implements SkillService{

	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll(), "Data başarıyla listelendi!");
	}

	@Override
	public Result add(Skill skill) {
		// TODO Auto-generated method stub
		this.skillDao.save(skill);
		return new SuccessResult(skill.getName() + " başarıyla eklendi!");
	}
	

	
	
	
}
