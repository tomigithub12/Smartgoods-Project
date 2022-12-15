package com.example.smartgoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	//register user with uuid header
	@PostMapping("/save")
	public SmartGoods saveRequirement(@RequestBody String statement) {
		//SmartGoodsUser newUser = new SmartGoodsUser(uuid);
		String uuid = "11111";
		boolean isRupp = SmartGoods.checkIfRuppScheme(statement);
		SmartGoods newStatement = new SmartGoods(statement, uuid, isRupp);
		
		return this.SmartGoodsRepo.save(newStatement);
	}
}
