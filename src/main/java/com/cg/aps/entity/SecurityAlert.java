package com.cg.aps.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Ram Sai Vajrapu
 * security alert's entity class, id is auto generated
 *
 */
@Entity
@Table(name = "security_alerts_aps")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SecurityAlert {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String alertMessage;
	private String alertType;
	private LocalDate alertDate;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "guardId"),name = "guardId")
	@JsonIgnore
	private Guard guard;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "ownerId"),name = "ownerId")
	@JsonIgnore
	private Owner owner;
}
