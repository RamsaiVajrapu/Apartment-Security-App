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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "guardId")
	private GuardEntity guard;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ownerId")
	private OwnerEntity owner;
}
