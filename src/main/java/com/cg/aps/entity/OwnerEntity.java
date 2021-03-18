package com.cg.aps.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy = "owner")
	private Set<DeliveryEntity> deliverySet;
	@OneToMany(mappedBy = "owner")
	private Set<DomesticHelpEntity> helpSet;
	@OneToMany(mappedBy = "owner")
	private Set<VisitorEntity> visitorSet;
	@OneToMany(mappedBy = "owner")
	private Set<VehicleEntity> vehicleSet;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<SecurityAlertEntity> alertSet;
}
