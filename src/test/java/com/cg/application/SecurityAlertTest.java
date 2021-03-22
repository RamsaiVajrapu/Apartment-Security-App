package com.cg.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.cg.aps.application.ApartmentSecurityAppApplication;
import com.cg.aps.entity.SecurityAlert;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.SecurityAlertService;

@SpringBootTest(classes = ApartmentSecurityAppApplication.class)
@Transactional
@Rollback(true)
public class SecurityAlertTest {

	@Autowired
	private SecurityAlertService alertService;
	
	public SecurityAlert addAlert() throws DuplicateRecordException, RecordNotFoundException {
		SecurityAlert alert = new SecurityAlert();
		alert.setAlertDate(LocalDate.now());
		alert.setAlertType("Emergency");
		alert.setAlertMessage("Fire started on 5th floor");
		Integer id = alertService.addSecurityAlert(alert);
		return alertService.findByPk(id);
	} 
	
	/*
	 * check add alert
	 */
	@Test
	public void testAddAlert() throws DuplicateRecordException, RecordNotFoundException {
		SecurityAlert alert = addAlert();
		assertEquals("Emergency", alert.getAlertType());
		assertNotEquals("just joking",alert.getAlertMessage());
	}
	
	/*
	 * check edit alert
	 */
	@Test
	public void testEditAlert() throws DuplicateRecordException, RecordNotFoundException {
		SecurityAlert alert = addAlert();
		alert.setAlertMessage("emergency in 6th floor");
		alert.setAlertType("less urgent");
		alertService.updateSecurityAlert(alert);
		assertNotEquals("LOL",alertService.findByPk(alert.getId()).getAlertMessage());
		assertNotEquals("Emergency",alertService.findByPk(alert.getId()).getAlertType());
	}
	
	/*
	 * check delete alert
	 */
	@Test
	public void testDeleteAlert() throws DuplicateRecordException, RecordNotFoundException {
		SecurityAlert alert = addAlert();
		alertService.deleteSecurityAlert(alert);
		assertThrows(RecordNotFoundException.class, ()->{
			alertService.findByPk(alert.getId());
			});
	}
}
