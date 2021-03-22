package com.cg.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.cg.aps.application.ApartmentSecurityAppApplication;
import com.cg.aps.entity.Vehicle;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.VehicleService;

@SpringBootTest(classes = ApartmentSecurityAppApplication.class)
@Transactional
@Rollback(true)
public class VehicleTest {

	@Autowired
	private VehicleService vehicleService;
	
	public Vehicle addVehicle() throws DuplicateRecordException, RecordNotFoundException {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleNo("AP 31 BR 1111");
		vehicle.setVehicleType("Bike");
		vehicle.setParkingNo("10");
		vehicle.setBasementLevel("-1");
		String id = vehicleService.addVehicle(vehicle);
		return vehicleService.findByPk(id);
	}
	
	/*
	 * check add vehicle
	 */
	@Test
	public void testAddVehicle() throws DuplicateRecordException, RecordNotFoundException {
		Vehicle vehicle = addVehicle();
		assertEquals("AP 31 BR 1111",vehicle.getVehicleNo());
		assertNotEquals("Truck",vehicle.getVehicleType());
		assertEquals("-1", vehicle.getBasementLevel());
	}
	
	/*
	 * check edit vehicle
	 */
	@Test
	public void testEditVehicle() throws DuplicateRecordException, RecordNotFoundException {
		Vehicle vehicle = addVehicle();
		vehicle.setBasementLevel("0");;
		vehicle.setParkingNo("25");
		vehicleService.updateVehicle(vehicle);
		assertNotEquals("-1",vehicleService.findByPk(vehicle.getVehicleNo()).getBasementLevel());
		assertEquals("25",vehicleService.findByPk(vehicle.getVehicleNo()).getParkingNo());
	}
	
	/*
	 * check delete vehicle
	 */
	@Test
	public void testDeleteVehicle() throws DuplicateRecordException, RecordNotFoundException {
		Vehicle vehicle = addVehicle();
		vehicleService.deleteVehicle(vehicle);
		assertThrows(RecordNotFoundException.class, ()->{
			vehicleService.findByPk(vehicle.getVehicleNo());
			});
	}
}
