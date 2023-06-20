//package com.csm.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
//
//import com.sun.istack.NotNull;
//
//import lombok.Data;
//
//@Entity
//@Data
//public class Register 
//{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@NotEmpty
//	@Size(min = 3,message = "name may not be empty or less than 3")
//	private String name;
//	@javax.validation.constraints.NotNull
//	@Size(min = 3,message = "Username May not be Null")
//	@Column(unique = true)
//	private String username;
//	@Email
//	@NotBlank(message = "email not null")
//	private String email;
//	
//	private String password;
//
//}
