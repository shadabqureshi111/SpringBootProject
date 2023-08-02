package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.userRepository;

@Service
public class UserService 
{
	@Autowired
	private userRepository userRepository;

	    //private List<User> users = new ArrayList<>();

	    public Optional<User> getuserById(Long id) 
	    {
	    	Optional<User> findById = userRepository.findById(id);
	    
	    	return findById;
//	        User user1 = new User();
//	        user1.setId(1L);
//	        user1.setIsSubscribe("Yes");
//	        users.add(user1);
//
//	        User user2 = new User();
//	        user2.setId(2L);
//	        user2.setIsSubscribe("No");
//	        users.add(user2);
//
//	        return users;
	    }

//	    public List<User> findUser(String status) 
//	    {
//	        List<User> findUser = new ArrayList<>();
//	        for (User user : users) 
//	        {
//	            if (user.getIsSubscribe().equalsIgnoreCase(status)) 
//	            {
//	            	findUser.add(user);
//	            }
//	        }
//	        return findUser;
//	    }
    
}