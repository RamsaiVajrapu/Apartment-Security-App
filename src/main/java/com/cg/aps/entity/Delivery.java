package com.cg.aps.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Shishir
 * delivery entity class, delivery id is auto generated
 *
 */
@Entity
@Table(name = "delivery_aps")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deliveryId;
	@Column(nullable = false)
	private String personName;
	@Column(nullable = false)
	private LocalDateTime deliveryDateTime;
	@Column(columnDefinition = "varchar(255) default 'Pending'")
	private String status;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "guardId"),name = "guardId")
	private Guard guard;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "ownerId"),name = "ownerId")
	private Owner owner;
	
}
