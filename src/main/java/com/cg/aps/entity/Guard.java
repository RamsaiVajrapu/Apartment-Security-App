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
 * @author Naga Vishnu
 * Guard's entity class and mapped by delivery, help, visitor and alerts
 *
 */
@Entity
@Table(name = "guards_aps")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Guard {
	@Id
	private Integer guardId;
	@Column(nullable = false)
	private String guardName;
	@Column(nullable = false)
	private Long mobileNo;
	@Column(nullable = false)
	private String emailId;
	@OneToMany(mappedBy = "guard")
	private Set<Delivery> deliverySet;
	@OneToMany(mappedBy = "guard")
	private Set<DomesticHelp> helpSet;
	@OneToMany(mappedBy = "guard")
	private Set<Visitor> visitorSet;
	@OneToMany(mappedBy = "guard")
	private Set<SecurityAlert> alertSet;
	@OneToMany(mappedBy = "guard")
	private Set<GuardShift> guardShiftSet;
	@OneToOne(mappedBy = "role")
	private User user;
	
}
