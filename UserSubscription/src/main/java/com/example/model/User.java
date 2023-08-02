package com.example.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String isSubscribe;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsSubscribe() {
		return isSubscribe;
	}
	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}
	
	
}
