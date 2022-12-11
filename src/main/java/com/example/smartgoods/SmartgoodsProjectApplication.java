package com.example.smartgoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.example.smartgoods.controller", "com.example.smartgoods.domain", "com.example.smartgoods.repository"})
@EnableJpaRepositories("com.example.smartgoods.repository")
//@ComponentScan(basePackages = { "com.example.smartgoods.controller", "com.example.smartgoods.domain", "com.example.smartgoods.repository" })
@EntityScan({"com.example.smartgoods.domain", "com.example.smartgoods.repository", "com.example.smartgoods.controller"}) 
public class SmartgoodsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartgoodsProjectApplication.class, args);
		//Test
	}

}
