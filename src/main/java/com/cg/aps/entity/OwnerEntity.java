package com.cg.aps.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "owners")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OwnerEntity {
	@Id
	private Integer ownerId;
	private String ownerName;
	private Long mobileNo;
	private Integer flatNo;
	private Integer floorNo;
}
