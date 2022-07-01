package com.hexaware.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.spring.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim,Long> {

}
