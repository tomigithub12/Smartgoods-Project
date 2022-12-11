package com.example.smartgoods.domain;

import jakarta.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Table;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
@Table(name = "UserData")
public class SmartGoodsUser {

	@Id
	@NotNull
	@Column(name = "UUID")
	private String uuid;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_password")
	private String userPassword;
	
	public SmartGoodsUser() {
		super();
	}
	
	public SmartGoodsUser(String UUID) {
		this.uuid = UUID;
	}
	
	public SmartGoodsUser(String UUID,String userName, String userEmail, String userPassword) {
		this.uuid = UUID;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	
	
}
