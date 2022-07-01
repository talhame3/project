package com.hexaware.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hexaware.spring.model.Claim;
import com.hexaware.spring.service.ClaimService;

@Controller
public class ClaimController {
	
	@Autowired
	private ClaimService cs;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listClaim",cs.getAllClaim());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewClaimForm(Model model) {
		Claim claim = new Claim();
		model.addAttribute("claim", claim);
		return "new_claim";
	}
	
	@PostMapping("/saveClaim")
	public String saveClaim(@Validated @ModelAttribute("claim") Claim claim) {
		cs.saveClaim(claim);
		return "redirect:/";
		
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value ="id")long id,Model model) {
		Claim claim = cs.getClaimById(id);
		model.addAttribute("claim",claim);
		return "update_claim";
	}
	@GetMapping("/deleteClaim/{id}")
	public String deleteClaim(@PathVariable (value ="id")long id) {
		this.cs.deleteClaimById(id);
		return "redirect:/";
		
	}

}
