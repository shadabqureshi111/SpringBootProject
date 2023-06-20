package com.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csm.model.Dept;

public interface DeptRepository extends JpaRepository<Dept,Integer>
{

}
