package com.cg.aps.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Vedang
 * owner entity class and class has associations with delivery, domestic help, visitors,
 * alerts and vehicles
 *
 */
@Entity
@Table(name = "owners_aps")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Owner {
	@Id
	private Integer ownerId;
	@Column(nullable = false)
	private String ownerName;
	@Column(nullable = false)
	private Long mobileNo;
	@Column(nullable = false)
	private String emailId;
	@OneToMany(mappedBy = "owner")
	private Set<Delivery> deliverySet;
	@OneToMany(mappedBy = "owner")
	private Set<DomesticHelp> helpSet;
	@OneToMany(mappedBy = "owner")
	private Set<Visitor> visitorSet;
	@OneToMany(mappedBy = "owner")
	private Set<Vehicle> vehicleSet;
	@OneToMany(mappedBy = "owner")
	private Set<SecurityAlert> alertSet;
	@OneToMany(mappedBy = "owner")
	private Set<FlatDetails> FlatDetailsSet;
	@OneToOne(mappedBy = "role")
	private User user;
}
