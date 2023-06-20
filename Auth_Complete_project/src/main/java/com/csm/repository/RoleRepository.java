package com.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csm.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> 
{

}
