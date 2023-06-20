package com.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csm.model.User;
import com.csm.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepo;

	@Override
	public User Find(String username,String password) 
	{
		User result = userRepo.findByUsernameAndPassword(username,password);
		return result;
	}

}
