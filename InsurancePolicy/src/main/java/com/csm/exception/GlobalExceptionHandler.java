package com.csm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex , WebRequest req){
        ErrorDetails errorDetails = new ErrorDetails(new Date() , ex.getMessage() , req.getDescription(false));
        return new ResponseEntity<>(errorDetails , HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> globalExceptionHandler(Exception ex , WebRequest request){
//        ErrorDetails errorDetails = new ErrorDetails(new Date() , ex.getMessage() , request.getDescription(false));
//        return new ResponseEntity<>(errorDetails , HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> resp = new HashMap<>();
     ex.getBindingResult().getAllErrors().forEach((error)->{
    	 String fieldName = ((FieldError)error).getField();
    	 String message = error.getDefaultMessage();
    	 resp.put(fieldName,message);
     });
        return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
    }
}