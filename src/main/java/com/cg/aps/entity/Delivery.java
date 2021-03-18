package com.cg.aps.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "delivery")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryId;
	//private Integer guardId;
	//private Integer ownerId;
	private String personName;
	private LocalDateTime deliveryDateTime;
	private String status;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "guardId")
	private Guard guard;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ownerId")
	private Owner owner;
	
}
