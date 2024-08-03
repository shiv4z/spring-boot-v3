package in.shiv.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneBook {
	private Integer id;
	private String name;
	private String email;
	private Long phoneNo;
	

}
