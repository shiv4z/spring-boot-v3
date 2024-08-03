package in.shiv.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Account {
	
	@EmbeddedId
	private AccountPK accountPK;
	private String accHolderName;
	private String address;

}
