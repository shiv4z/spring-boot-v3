package in.shiv.rest;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.binding.Country;

@RestController
public class CountryRestController {
	
	private HashOperations<String, Integer, Country> hashOps;
	
	CountryRestController(RedisTemplate<String, Country> template){
		this.hashOps = template.opsForHash();
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Country country) {
		hashOps.put("COUNTRY", country.getId(), country);
		return new ResponseEntity<>("Country Details Saved.", HttpStatus.CREATED);
	}
	
	@GetMapping("/country/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable ("id")Integer id){
		Country country = hashOps.get("COUNTRY", id);
		return  new ResponseEntity<>(country, HttpStatus.OK);
	}

	@GetMapping("/countries")
	public ResponseEntity<List<Country>> fetchAll(){
		List<Country> countryList = hashOps.values("COUNTRY");
		return new ResponseEntity<>(countryList, HttpStatus.OK);
	}
}
