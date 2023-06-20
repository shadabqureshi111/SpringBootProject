package com.csm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csm.model.PriceDtl;


@Repository
public interface PriceDtlRepo extends JpaRepository<PriceDtl, Integer> {

}
