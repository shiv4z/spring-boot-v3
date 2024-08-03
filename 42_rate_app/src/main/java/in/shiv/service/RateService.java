package in.shiv.service;

import org.springframework.stereotype.Service;

import in.shiv.constant.RateConstant;

@Service
public class RateService {
	
	private RateConstant interestRate;
	
	
	public Double rate(String type) {
		switch (type) {
		case "HOUSE_LOAN": return interestRate.HOUSE_LOAN;
		case "PROPERTY_LOAN": return interestRate.PROPERTY_LOAN;
		case "EDUCATION_LOAN": return interestRate.EDUCATION_LOAN;
		case "CAR_LOAN": return interestRate.CAR_LOAN;
		case "GOLD_LOAN": return interestRate.GOLD_LOAN;
		default:
			return 5.0;
		}
	}

}
