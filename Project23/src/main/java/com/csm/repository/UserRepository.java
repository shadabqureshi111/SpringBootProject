package com.csm.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csm.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{

	 //void save(@Valid Users users);

}
