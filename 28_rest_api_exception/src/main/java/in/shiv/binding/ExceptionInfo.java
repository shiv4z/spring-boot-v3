package in.shiv.binding;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionInfo {
	
	private String code;
	private String msg;
	private LocalDateTime date;
	

}
