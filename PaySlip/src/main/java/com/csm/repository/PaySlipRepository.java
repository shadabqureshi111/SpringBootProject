package com.csm.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csm.model.Payslip;

@Repository
public interface PaySlipRepository extends JpaRepository<Payslip,Long>
{
	

}
