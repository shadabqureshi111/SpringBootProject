package com.csm.model;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class Users implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;

	@NotEmpty
	@Size(min = 3, message = "name may not be empty or less than 3")
	private String name;

	@NotEmpty
	@Size(min = 3, message = "Username may not be empty or less than 3")
	private String username;

	@NotEmpty
	@Size(min = 5, message = "Password may not be empty or less than 5")
	private String password;

	private Long enable;

//	@ManyToOne(cascade = CascadeType.ALL,targetEntity =Roles.class)
//	@JoinColumn(name = "role_id",referencedColumnName = "role_id")
//	public Roles roles;
	

//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
//	@ManyToOne(cascade = CascadeType.ALL,targetEntity =Roles.class)
//	@JoinColumn(name = "role_id",referencedColumnName = "role_id")
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Roles.class)
	@JoinColumn(name = "fk_role_id")
	private Roles role;
}
