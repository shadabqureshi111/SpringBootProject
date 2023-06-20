package com.csm.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
//
//@Entity
//@Data
//public class UserRole 
//{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long userRoleId;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	private User user;
//	
//	@ManyToOne
//	private Role role;
//
//}
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    @JsonIgnore
    private Role role;

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

    
    
    
    
    
    
    
//    @Override
//    public int hashCode() {
//        return Objects.hash(userRoleId);
//    }
}
