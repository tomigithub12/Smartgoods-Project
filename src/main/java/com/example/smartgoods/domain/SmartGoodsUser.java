package com.example.smartgoods.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


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
	
	@Column(name = "quantity")
	@Formula(value = "(SELECT COUNT (requirement) FROM user_requirements r WHERE r.user_uuid = uuid)")
	private int quantity;
	
//	@OneToMany(targetEntity = SmartGoods.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_UUID", referencedColumnName = "UUID") //linkes welche in die Andere Tabelle erzeugt werden soll und rechts welche von uns reingeht
//	private List<SmartGoods> requirements = new ArrayList<>();
	
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	
}
