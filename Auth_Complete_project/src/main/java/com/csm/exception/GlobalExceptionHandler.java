package com.csm.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> ResourceNotFoundException(ResourceNotFoundException ex, WebRequest request)
	{
			ErrorDetail errorDetail = new ErrorDetail(new Date(),ex.getMessage(),request.getDescription(false));
			return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> GlobalException(Exception ex, WebRequest request)
	{
		ErrorDetail errorDetail = new ErrorDetail(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetail,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> HandelMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map <String,String> map = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->
		{
			String field = ((FieldError)error).getField();
			String msg = error.getDefaultMessage();
			map.put(field,msg);
		});
		
		return  new ResponseEntity<Map<String ,String>>(map,HttpStatus.BAD_REQUEST);
		
	}
	
	
	

}
