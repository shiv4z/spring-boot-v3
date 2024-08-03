package in.shiv.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.shiv.binding.ExceptionInfo;
import in.shiv.binding.UserNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionInfo> handleException(Exception e) {
		logger.error(e.getMessage());
		ExceptionInfo info = new ExceptionInfo();
		info.setCode("REST0023");
		info.setMsg(e.getMessage());
		System.out.println(e.getLocalizedMessage());
		System.out.println(e.getMessage());
		info.setDate(LocalDateTime.now());
		return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionInfo> handleUNE(UserNotFoundException ue){
		logger.error(ue.getMessage());
		ExceptionInfo info = new ExceptionInfo();
		info.setCode("REST0030");
		info.setMsg(ue.getMessage());
		info.setDate(LocalDateTime.now());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

}
