package in.shiv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {

	Logger logger = LoggerFactory.getLogger(ExceptionHandlerClass.class);

	@ExceptionHandler(NullPointerException.class)
	public String handleNPE(NullPointerException e) {
		logger.error(e.getMessage());
		return "errorPage";
	}

	@ExceptionHandler(ArithmeticException.class)
	public String handleException(ArithmeticException ae) {
		logger.info(ae.getMessage());
		return "errorPage";
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		logger.info(e.getMessage());
		return "errorPage";
	}
}
