package com.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csm.model.User;

public interface UserRepo extends JpaRepository<User,String>
{


	public User findByUsername(String username);
	

}
