package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

public interface userRepository extends JpaRepository<User,Long>
{

}
