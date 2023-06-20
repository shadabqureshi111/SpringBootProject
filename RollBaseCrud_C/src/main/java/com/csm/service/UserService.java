package com.csm.service;

import com.csm.model.User;

public interface UserService 
{
	public User Find(String username,String password);
}
