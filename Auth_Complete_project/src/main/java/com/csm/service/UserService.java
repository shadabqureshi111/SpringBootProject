package com.csm.service;

import java.util.Set;

import com.csm.model.User;
import com.csm.model.UserRole;

public interface UserService 
{
	public User saveUser(User user,Set<UserRole> userRoles) throws Exception;
	
	public User GetUserById(String username) throws Exception;
	
	public void deleteUserById(Long id);
}
