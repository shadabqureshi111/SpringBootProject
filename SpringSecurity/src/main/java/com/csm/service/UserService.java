package com.csm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
@Service
public class UserService 
{
	List<com.csm.model.User> list=new ArrayList<>();
	
	public UserService()
	{
		list.add(new com.csm.model.User("shadab", "12345","s@gmail.com",""));
		list.add(new com.csm.model.User("rajesh", "12345","r@gmail.com", null));
	}

	public List<com.csm.model.User> getAllUsers()
	{
		return this.list;
	}
	
	public com.csm.model.User getUser(String username)
	{
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	public com.csm.model.User adduser(com.csm.model.User user)
	{
		this.list.add(user);
		return user;
	}
}
