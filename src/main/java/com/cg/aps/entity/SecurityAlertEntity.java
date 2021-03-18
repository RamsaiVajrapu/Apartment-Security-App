package com.cg.aps.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "security-alerts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SecurityAlertEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer guardId;
	private Integer ownerId;
	private String alertMessage;
	private String alertType;
	private LocalDate alertDate;
	@ManyToMany(mappedBy = "alertSet")
	private Set<GuardEntity> guardSet;
	@ManyToMany(mappedBy = "alertSet")
	private Set<OwnerEntity> ownerSet;
}
