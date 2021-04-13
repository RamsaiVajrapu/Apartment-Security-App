package com.cg.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.cg.aps.application.ApartmentSecurityAppApplication;
import com.cg.aps.entity.Visitor;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.VisitorService;

@SpringBootTest(classes = ApartmentSecurityAppApplication.class)
@Transactional
@Rollback(true)
public class VisitorTest {

	@Autowired
	private VisitorService visitorService;
	
	public Visitor addVisitor() throws DuplicateRecordException, RecordNotFoundException {
		Visitor visitor = new Visitor();
		visitor.setFlatNo(12);
		visitor.setVisitorName("Kumar");
		visitor.setArrivalDate(LocalDate.now());
		visitor.setDepartureDate(null);
		Integer id = visitorService.addVisitor(visitor);
		return visitorService.findByPk(id);
	} 
	
	/*
	 * check add visitor
	 */
	@Test
	public void testAddVisitor() throws DuplicateRecordException, RecordNotFoundException {
		Visitor visitor = addVisitor();
		assertEquals(12, visitor.getFlatNo());
		assertNotEquals("Smith",visitor.getVisitorName());
	}
	
	/*
	 * check edit visitor
	 */
	@Test
	public void testEditVisitor() throws DuplicateRecordException, RecordNotFoundException {
		Visitor visitor = addVisitor();
		visitor.setFlatNo(16);
		visitor.setDepartureDate(LocalDate.of(2021, 03, 23));
		visitorService.updateVisitor(visitor);
		assertNotEquals(LocalDateTime.now(),visitorService.findByPk(visitor.getVisitorId()).getDepartureDate());
		assertEquals(16,visitorService.findByPk(visitor.getVisitorId()).getFlatNo());
	}
	
	/*
	 * check delete visitor
	 */
	@Test
	public void testDeleteVisitor() throws DuplicateRecordException, RecordNotFoundException {
		Visitor visitor = addVisitor();
		visitorService.deleteVisitor(visitor);
		assertThrows(RecordNotFoundException.class, ()->{
			visitorService.findByPk(visitor.getVisitorId());
			});
	}
}
