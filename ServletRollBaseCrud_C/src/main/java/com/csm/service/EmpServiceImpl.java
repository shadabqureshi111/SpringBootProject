package com.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csm.model.Emp;
import com.csm.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService
{
	@Autowired
	private EmpRepository emprepo;
	
	@Override
	public Emp save(Emp emp) 
	{
		Emp empData = emprepo.save(emp);
		return empData;
	}

	@Override
	public List<Emp> getAll() 
	{
		
		return null;
	}

}
