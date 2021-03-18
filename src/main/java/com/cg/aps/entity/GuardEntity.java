package com.cg.aps.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
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
}
