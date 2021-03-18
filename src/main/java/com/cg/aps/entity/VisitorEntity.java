package com.cg.aps.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "visitors")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VisitorEntity {
	private Integer visitorId;
	private String VisitorName;
	private Integer ownerId;
	private Integer guardId;
	private Integer flatNo;
	private LocalDateTime arrivalDateTime;
	private LocalDateTime departureDateTime;
}
