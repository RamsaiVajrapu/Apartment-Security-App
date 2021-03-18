package com.cg.aps.entity;

import java.time.LocalDate;
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
@Table(name = "guards")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuardEntity {
	@Id
	private Integer guardId;
	private String guardName;
	private Long mobileNo;
	private String guardShift;
	private LocalDate guardDate;
	@OneToMany(mappedBy = "guard")
	private Set<DeliveryEntity> deliverySet;
	@OneToMany(mappedBy = "guard")
	private Set<DomesticHelpEntity> helpSet;
	@OneToMany(mappedBy = "guard")
	private Set<VisitorEntity> visitorSet;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<SecurityAlertEntity> alertSet;
	
}
