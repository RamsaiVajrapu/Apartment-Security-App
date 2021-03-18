package com.cg.aps.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "domestic-help")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DomesticHelpEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer helpId;
	private Integer guardId;
	private Integer ownerId;
	private String PersonName;
	private String helpType;
	private String arrivalTime;
	private String departureTime;
	private LocalDate helpDate;
}
