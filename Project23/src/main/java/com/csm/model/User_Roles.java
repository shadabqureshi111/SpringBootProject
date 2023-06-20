//package com.csm.model;
//
//import javax.annotation.Generated;
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//
//import lombok.Data;
//
//@Entity
//@Data
//public class User_Roles 
//{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Users.class)
//	@JoinColumn(name = "user_id")
//	public Users user_id;
//	
//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Roles.class)
//	@JoinColumn(name = "role_id")
//	public Roles roles_id;
//
//}
