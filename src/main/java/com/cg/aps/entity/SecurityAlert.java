package com.cg.aps.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//private Integer guardId;
	//private Integer ownerId;
	private String alertMessage;
	private String alertType;
	private LocalDate alertDate;
	@ManyToOne(cascade = CascadeType.ALL)
	private Guard guard;
	@ManyToOne(cascade = CascadeType.ALL)
	private Owner owner;
}
