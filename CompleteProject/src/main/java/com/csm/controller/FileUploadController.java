package com.csm.controller;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.csm.common.FileUpload;

@RestController
public class FileUploadController 
{
	@Autowired
	private FileUpload fileUpload;
	
	@PostMapping("/check")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		try
		{
		/* Validation */
			if(file.isEmpty())
				{
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
				}
			if(!file.getContentType().equals("image/jpeg"))
				{
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg file are allowed");
				}
		
		//File Upload Code
			boolean f = fileUpload.uploadFile(file);
				
			if(f)
			{
				//return ResponseEntity.ok("File is Successfully Uploaded");
				
				/* If you want to show URL than write */
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}
			}
		catch (Exception e) 
			{

			}
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong!! Try Again");
	}

}
