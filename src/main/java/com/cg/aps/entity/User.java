package com.cg.aps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Vikas
 * login module POJO class(entity). two types of users 
 * one is guard and other is owner
 *
 */
@Entity
@Table(name = "users_aps")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	@Id
	private Integer userId;
	private String password;
	private String name;
	private Long mobileNo;
	private String emailId;
	private String role;
	private String status;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "guardId")
	private Guard guard;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ownerId")
	private Owner owner;
}
