package in.shiv.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.binding.Rate;
import in.shiv.service.LoanService;

@RestController
public class LoanRestController {

	@Autowired
	private LoanService service;

	@GetMapping("/loan")
	public ResponseEntity<Rate> loan(@RequestParam("type") String type) {
		Rate rate = service.gerRate(type);
		return new ResponseEntity<>(rate, HttpStatus.OK);
	}

	
}
