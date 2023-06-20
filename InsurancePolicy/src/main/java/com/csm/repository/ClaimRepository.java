package com.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csm.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long>{
}