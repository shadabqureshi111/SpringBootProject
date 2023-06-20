package com.csm.service;

import com.csm.model.User;
import com.csm.model.UserRole;
import com.csm.repository.RoleRepository;
import com.csm.repository.UserRepository;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	private User save;

	 // private final PasswordEncoder passwordEncoder;
	
	//Creating User
	@Override
	public User saveUser(User user, Set<UserRole> userRoles) throws Exception
	{
		{
			User localUsername = this.userRepository.findByUsername(user.getUsername());
			
			if(localUsername!=null)
			{
				System.out.println("User is already register");
				throw new Exception("user already exist");
			}
			else
			{
				for(UserRole ur:userRoles)
				{
					roleRepository.save(ur.getRole());
				}
			user.getUserRole().addAll(userRoles);
			save = userRepository.save(user);
			}
			return save;
		}
	}

	@Override
	public User GetUserById(String username) throws Exception 
	{
		User findByusername = this.userRepository.findByUsername(username);
		System.out.println(findByusername);
		if(findByusername==null)
		{
			 throw new Exception("User not found");
		}
		else
		{
			return findByusername ;
		}
	}

	@Override
	public void deleteUserById(Long id) 
	{
			userRepository.deleteById(id);
		
	}
	
  
 


}
