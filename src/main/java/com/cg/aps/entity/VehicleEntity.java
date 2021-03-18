package com.cg.aps.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleEntity {
	@Id
	private Integer ownerId;
	private String parkingNo;
	private String basementLevel;
	private Integer vehicleNo;
	private String vehicleType;
}
