package com.csm.service;

import org.springframework.stereotype.Service;

import com.csm.entity.Claim;
import com.csm.exception.ResourceNotFoundException;
import com.csm.repository.ClaimRepository;

@Service
public class ClaimService 
{
	private final ClaimRepository claimRepository;

	public ClaimService(ClaimRepository claimRepository) {
	    this.claimRepository = claimRepository;
	}

	public List<Claim> getAllClaims() {
	    return claimRepository.findAll();
	}

	public Claim getClaimById(Long id) {
	    return claimRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Claim", "id", id));
	}

	public Claim createClaim(Claim claim) {
	    return claimRepository.save(claim);
	}

	public Claim updateClaim(Long id, Claim claimDetails) {
	    Claim claim = claimRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Claim", "id", id));

	    claim.setClaimNumber(claimDetails.getClaimNumber());
	    claim.setDescription(claimDetails.getDescription());
	    claim.setClaimDate(claimDetails.getClaimDate());
	    claim.setClaimStatus(claimDetails.getClaimStatus());

	    return claimRepository.save(claim);
	}

	public void deleteClaim(Long id) {
	    Claim claim = claimRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Claim", "id", id));

	    claimRepository.delete(claim);
	}
	

}
