package in.shiv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.shiv.binding.Rate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class LoanService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanService.class);	
	@Autowired
	private RestTemplate template;
	
	@CircuitBreaker(name = "loanService", fallbackMethod = "m1")
	public Rate gerRate(String type) {
		System.out.println("******** Original method calling *********");

		String url = "http://localhost:8080/rate?type={type}";
		 logger.info("Requesting rate from URL: {}", url);
	        try {
	            ResponseEntity<Rate> responseEntity = template.getForEntity(url, Rate.class, type);
	            return responseEntity.getBody();
	        } catch (Exception e) {
	            logger.error("Error occurred while fetching rate: ", e);
	            throw e;
	        }
	}

	public Rate  m1(Throwable t) {
		System.out.println("******** fallback method calling *********");
		Rate rate = new Rate();
		return rate;
	}
}
