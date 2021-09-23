package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CountryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.Country;

@RestController
@RequestMapping("/api/countries")
public class CountriesController {

	private CountryService countryService;

	@Autowired
	public CountriesController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Country>> getAll(){
		return this.countryService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Country country) {
		return this.countryService.add(country);
	}
	
	
	
	
}
