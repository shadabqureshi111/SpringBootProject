package com.csm.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

@Component
public class FileUpload 
{
	/* if we want to give fix path than use this */
//	public final String UploadDirectory="E:\\JAVA_CODE\\Workspace3\\CompleteProject\\src\\main\\resources\\static\\image";
	
	/* For Dynamically Use */
	/*this will run when constructor call that's why this generate an exception 
	 * so for remove exception we will make a default constructor and handle exception*/
	public final String UploadDirectory= new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	/* This create because ClassPathResource give an error --
	 * */
	public FileUpload() throws IOException
	{
		
	}
	
	public boolean uploadFile(MultipartFile file)
	{
		boolean f=false;
		try
		{
//			InputStream is = file.getInputStream();
//			byte data[]=new byte[is.available()];
//			is.read(data);
//			
//			//Write
//		FileOutputStream fos=new FileOutputStream(UploadDirectory+java.io.File.separator+file.getOriginalFilename());
//		fos.write(data);
//		fos.flush();
//		fos.close();
		
		
		Files.copy(file.getInputStream(),Paths.get(UploadDirectory+java.io.File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		f=true;
		}
		catch (Exception e) 
		{

		}
		return f;
	}

}
