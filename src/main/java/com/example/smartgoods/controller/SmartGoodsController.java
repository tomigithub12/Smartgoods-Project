package com.example.smartgoods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartgoods.domain.SmartGoods;
import com.example.smartgoods.domain.SmartGoodsUser;
import com.example.smartgoods.repository.SmartGoodsRepository;

@RestController
@RequestMapping("api/smartgoods")
public class SmartGoodsController {
	
	@Autowired
	private SmartGoodsRepository SmartGoodsRepo;

	@GetMapping("list/all/{uuid}")
	public List<SmartGoods> getAllSmartGoods(@PathVariable(value = "uuid") String uuid){
		return this.SmartGoodsRepo.findAllByuserUUID(uuid);
	}
	
	//register user with uuid header
	@PostMapping("/save")
	public SmartGoods saveRequirement(@RequestBody SmartGoods requirement) {
		//SmartGoodsUser newUser = new SmartGoodsUser(uuid);
		String uuid = requirement.getUserUUID();
		String req = requirement.getRequirement();
		boolean isRupp = SmartGoods.checkIfRuppScheme(req);
		SmartGoods newRequirement = new SmartGoods(req, uuid, isRupp);
		
		return this.SmartGoodsRepo.save(newRequirement);
	}
	
	@PostMapping("/check")
	public boolean checkRequirement(@RequestBody String requirement) {
		//SmartGoodsUser newUser = new SmartGoodsUser(uuid);
		boolean isRupp = SmartGoods.checkIfRuppScheme(requirement);
		
		return isRupp;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable(value = "id") Long id) {
		
		this.SmartGoodsRepo.deleteById(id);
		return "deleted";
	}
	
	
}
