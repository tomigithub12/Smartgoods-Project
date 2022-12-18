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
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "UserRequirements")
public class SmartGoods {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

	@Column(name = "requirement")
	private String requirement;
	
	@Column(name = "user_UUID")
	private String userUUID;
	
	@Column(name = "RuppScheme")
    private boolean isRuppScheme;
	
	@Column(name = "Created")
	private LocalDateTime created;
	
	@Column(name = "Modified")
    private LocalDateTime modified;
	
	
	public SmartGoods() {
		super();
	}

	public SmartGoods(String requirement, String uuid) {
		LocalDateTime date = LocalDateTime.now();
		this.requirement = requirement;
		this.userUUID = uuid;
		this.created = date;
		this.modified = date;
	}
	
	public SmartGoods(String requirement, String uuid, boolean isRuppScheme) {
		LocalDateTime date = LocalDateTime.now();
		this.requirement = requirement;
		this.userUUID = uuid;
		this.created = date;
		this.modified = date;
		this.isRuppScheme = isRuppScheme;
	}
	
	public SmartGoods(String requirement, boolean isRuppScheme) {
		this.requirement= requirement;
		this.isRuppScheme = isRuppScheme;
	}
    
    public static boolean checkIfRuppScheme(String requirement) {
    	
    	String[] requiredWords = new String[]{"shall","should","will","with","the","ability","to","be","able","to"};
    	
    	if(requirement.contains(requiredWords[0]) || requirement.contains(requiredWords[1]) || requirement.contains(requiredWords[2]) ){
    		return true;
    	} else return false;
    	
    	
//    	if(requirement.contains(requiredWords[0])){
//    		int position = requirement.indexOf(requiredWords[0]);
//    		String sub = requirement.substring(position + 6, position + 10);
//    		sub.replaceAll("\\s", "");
//    		
//    		if(sub.equals("theabilityto")) {
//    			return true;
//    		} else {
//    		    return false;
//    		}
//    	} else { return false; }
    	
//    	if(requirement.contains(requiredWords[0]) || requirement.contains(requiredWords[1]) || requirement.contains(requiredWords[2])) {
//    		
//    		int[] positions = new int[]{requirement.indexOf(requiredWords[0]), requirement.indexOf(requiredWords[1]), requirement.indexOf(requiredWords[2])};
    		
    	//if(positionChecker(requirement, requiredWords, positions)) return true;
    		
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}
    

}
