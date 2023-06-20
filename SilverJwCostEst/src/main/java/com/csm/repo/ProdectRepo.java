package com.csm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csm.model.ProductDtl;

public interface ProdectRepo extends JpaRepository<ProductDtl, Integer> {

}
