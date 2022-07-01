package com.hexaware.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.spring.model.Claim;
import com.hexaware.spring.repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository claimRepository;
	
	@Override
	public List<Claim> getAllClaim() {
		return claimRepository.findAll();
	}

	@Override
	public void saveClaim(Claim claim) {
		this.claimRepository.save(claim);
		
	}

	@Override
	public Claim getClaimById(Long id) {
		Optional<Claim> optional = claimRepository.findById(id);
		Claim claim = null;
		if(optional.isPresent()) {
			claim = optional.get();
		}else {
			throw new RuntimeException("Cliam not found for this Id ::"+ id);
		}
		return claim;
	}

	@Override
	public void deleteClaimById(Long id) {
		this.claimRepository.deleteById(id);
		
	}

}
