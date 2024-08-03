package in.shiv.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.binding.Rate;
import in.shiv.service.RateService;

@RestController
public class RateRestController {
	
	@Autowired
	private RateService service;
	@GetMapping("/rate")
	public ResponseEntity<Rate> rate(@RequestParam ("type")String type){
		Rate rate = new Rate();
		rate.setId(142154);
		rate.setRate(service.rate(type));
		rate.setType(type);
		return new ResponseEntity<>(rate, HttpStatus.OK);
	}
	

}
