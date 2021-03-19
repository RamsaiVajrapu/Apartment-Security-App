package com.cg.aps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Devarshi
 * entity class of vehicle module. vehicleNo is the primary key and joins column of owner class
 *
 */
@Entity
@Table(name = "vehicles_aps")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
	@Id
	private String vehicleNo;
	//private Integer ownerId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ownerId")
	private Owner owner;
	private String parkingNo;
	private String basementLevel;
	private String vehicleType;
	
}
