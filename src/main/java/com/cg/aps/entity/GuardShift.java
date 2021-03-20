package com.cg.aps.entity;

import java.time.LocalDate;

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
 * @author Naga Vishnu
 * guard shift entity
 *
 */
@Entity
@Table(name = "guard_shift_aps")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuardShift {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shiftId;
	@Column(nullable = false)
	private String guardShift;
	@Column(nullable = false)
	private LocalDate guardDate;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "guardId"),name = "guardId")
	private Guard guard;
}
