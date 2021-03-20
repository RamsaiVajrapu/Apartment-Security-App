package com.cg.aps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private String role;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private Owner owner;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private Guard guard;
	
}
