package com.example.smartgoods.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserRequirements")
public class SmartGoods {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
	
	@Column(name = "UUID")
	private String UUID;

	@Column(name = "statement")
	private String statement;
	
//	@ManyToOne
//	@Column(name = "UUID")
//	@JoinColumn(name = "UUID", referencedColumnName = "UUID")
//	private String UUID;
	
	@Column(name = "RuppScheme")
    private boolean isRuppScheme;
	
	@Column(name = "Created")
	private LocalDateTime created;
	
	@Column(name = "Modified")
    private LocalDateTime modified;
	
	
    
	public SmartGoods(String statement, String uuid, boolean isRuppScheme) {
		LocalDateTime date = LocalDateTime.now();
		this.statement = statement;
		this.UUID = uuid;
		this.created = date;
		this.modified = date;
		this.isRuppScheme = isRuppScheme;
	}
	
	public SmartGoods(String statement, boolean isRuppScheme) {
		this.statement= statement;
		this.isRuppScheme = isRuppScheme;
	}
    
    public static boolean checkIfRuppScheme(String statement) {
    	String requiredShall = "shall";
    	String requiredShould = "should";
    	String requiredWill = "will";
    	String requiredAbility = "withtheabilityto";
    	String requiredBeAbleTo = "beableto";
    	
    	if(statement.contains(requiredShall) || statement.contains(requiredShould) || statement.contains(requiredWill)) {
    		return true;
    	} else return false;
    }

}
