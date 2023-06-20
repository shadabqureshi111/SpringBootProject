package com.csm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GlobalException extends Exception
{

	public GlobalException(String s) 
	{
		super(s);
	}


}
