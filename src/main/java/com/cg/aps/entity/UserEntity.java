package com.cg.aps.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {
	@Id
	private Integer loginId;
	private String password;
	private String name;
	private Long mobileNo;
	private String emailId;
	private String role;
	private String status;
}
