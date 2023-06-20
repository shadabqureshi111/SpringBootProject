package com.csm.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.csm.dao.UserRepository;
import com.csm.model.User;

public class UserDetailServiceImpl implements UserDetailsService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		//fetching user from database
		User user = userRepository.getUserByName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("Could not found!!");
		}
		CustomUserDetail customUserDetail=new CustomUserDetail(user);
		return customUserDetail;
	}
	

}
