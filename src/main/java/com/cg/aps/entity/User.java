package com.cg.aps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	@Column(nullable = false,length = 20)
	private String password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Long mobileNo;
	@Column(nullable = false)
	private String emailId;
	@Column(nullable = false)
	@OneToOne
	private String role;
	
}
