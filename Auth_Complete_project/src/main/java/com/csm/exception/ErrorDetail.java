package com.csm.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetail 
{
	private Date timestamp;
	private String message;
	private String detail;

}
