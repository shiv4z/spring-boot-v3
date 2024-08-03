package in.shiv.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AccountPK {
	
	private Long accountNo;
	private String accType;

}
