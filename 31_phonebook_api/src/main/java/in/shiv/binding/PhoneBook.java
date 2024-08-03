package in.shiv.binding;

import in.shiv.entity.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneBook {
	
	private Integer id;
	
	@NotNull
	private Long phoneNo;
	
	@NotBlank(message = "name should not be blank")
	private String name;
	
	@NotBlank(message = "email should not be blank")
	@Email(message = "Please provide valid email")
	private String email;
	
	public PhoneBook(Phone phone){
		this.email = phone.getEmail();
        this.name = phone.getName();
        this.phoneNo = phone.getPhoneNo();
        this.id = phone.getId();
	}

}
