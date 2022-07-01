package com.hexaware.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.spring.model.Claim;

@Service
public interface ClaimService {
	
	List<Claim> getAllClaim();
	
	void saveClaim(Claim claim);
	
	Claim getClaimById(Long id);
	
	void deleteClaimById(Long id);
	

}
