package com.csm.service;

import java.util.List;

import com.csm.model.Emp;

public interface EmpService 
{
	public Emp save(Emp emp);
	public List<Emp> getAll();

}
