package com.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csm.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> 
{
}