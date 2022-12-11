package com.example.smartgoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartgoods.domain.SmartGoodsUser;
import com.example.smartgoods.repository.SmartGoodsUserRepository;


@RestController
@RequestMapping("api/user")
public class SmartGoodsUserController {


	@Autowired
	private SmartGoodsUserRepository SmartGoodsUserRepo;
	
	//register user with uuid
	@PostMapping("/registration/{uuid}")
	public String registerUserByUuid(@PathVariable(value = "uuid") String uuid) {
		SmartGoodsUser newUser = new SmartGoodsUser(uuid);
		if(this.SmartGoodsUserRepo.save(newUser).equals(newUser)) {
			return "Erfolg";
		}
		
		return "kein Erfolg";
	}
	
}
