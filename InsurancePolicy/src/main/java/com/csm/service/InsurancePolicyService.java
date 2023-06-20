package com.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csm.entity.InsurancePolicy;
import com.csm.exception.ResourceNotFoundException;
import com.csm.repository.InsurancePolicyRepository;

@Service
public class InsurancePolicyService 
{
private final InsurancePolicyRepository insurancePolicyRepository;

public InsurancePolicyService(InsurancePolicyRepository insurancePolicyRepository) {
    this.insurancePolicyRepository = insurancePolicyRepository;
}

public List<InsurancePolicy> getAllInsurancePolicies() {
    return insurancePolicyRepository.findAll();
}

public InsurancePolicy getInsurancePolicyById(Long id) {
    return insurancePolicyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("InsurancePolicy", "id", id));
}

public InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy) {
    return insurancePolicyRepository.save(insurancePolicy);
}

public InsurancePolicy updateInsurancePolicy(Long id, InsurancePolicy insurancePolicyDetails) {
    InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("InsurancePolicy", "id", id));

    insurancePolicy.setPolicyNumber(insurancePolicyDetails.getPolicyNumber());
    insurancePolicy.setType(insurancePolicyDetails.getType());
    insurancePolicy.setCoverageAmount(insurancePolicyDetails.getCoverageAmount());
    insurancePolicy.setPremium(insurancePolicyDetails.getPremium());
    insurancePolicy.setStartDate(insurancePolicyDetails.getStartDate());
    insurancePolicy.setEndDate(insurancePolicyDetails.getEndDate());

    return insurancePolicyRepository.save(insurancePolicy);
}

public void deleteInsurancePolicy(Long id) {
    InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("InsurancePolicy", "id", id));

    insurancePolicyRepository.delete(insurancePolicy);
	}
}