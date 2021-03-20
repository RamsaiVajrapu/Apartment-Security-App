package com.cg.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.aps.entity.Delivery;
import com.cg.aps.entity.DomesticHelp;
import com.cg.aps.entity.SecurityAlert;
import com.cg.aps.entity.Vehicle;
import com.cg.aps.entity.Visitor;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.DeliveryService;
import com.cg.aps.service.DomesticHelpService;
import com.cg.aps.service.SecurityAlertService;
import com.cg.aps.service.VehicleService;
import com.cg.aps.service.VisitorService;

import io.swagger.annotations.Api;
/**
 * 
 * @author Vedang
 *
 */
@Api
@RestController
@RequestMapping("/api/owner")
public class OwnerController {

	@Autowired
	private SecurityAlertService alertService;
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param alertId
	 * @return alert
	 */
	@GetMapping("/alert/{alertId}")
	public ResponseEntity<SecurityAlert> getAlertById(@PathVariable Integer alertId){
		try {
			SecurityAlert securityAlert = alertService.findByPk(alertId);
			return new ResponseEntity<>(securityAlert,HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Ram Sai Vajrapu
	 * @return all alerts
	 */
	@GetMapping("/alert")
	public ResponseEntity<List<SecurityAlert>> getAllAlerts(){
		try {
			List<SecurityAlert> alertList = alertService.search();
			return new ResponseEntity<>(alertList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param pageNo
	 * @param pageSize
	 * @return alerts of the pageNo with pageSize
	 */
	@GetMapping("/alert/{pageNo}/{pageSize}")
	public ResponseEntity<List<SecurityAlert>> getAlerts(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		try {
			List<SecurityAlert> alertList = alertService.search(pageNo, pageSize);
			return new ResponseEntity<>(alertList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param securityAlert
	 * @return adds alert
	 */
	@PostMapping("/alert")
	public ResponseEntity<Integer> addAlert(@RequestBody SecurityAlert securityAlert) {
		try {
			Integer alertId = alertService.addSecurityAlert(securityAlert);
			return new ResponseEntity<>(alertId,HttpStatus.OK);
		}catch(DuplicateRecordException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param securityAlert
	 * @return updating alerts
	 */
	@PutMapping("/alert")
	public ResponseEntity<String> updateEmployee(@RequestBody SecurityAlert securityAlert) {
		try {
			alertService.updateSecurityAlert(securityAlert);
			return new ResponseEntity<>("updated successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param empno
	 * @return
	 */
	@DeleteMapping("/alert")
	public ResponseEntity<String> deleteEmployee(@RequestBody SecurityAlert securityAlert) {
		try {
			alertService.deleteSecurityAlert(securityAlert);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	
	
	@Autowired
	private DeliveryService deliveryService;
	/**
	 * @author Shishir
	 * @param deliveryId
	 * @return delivery
	 */
	@GetMapping("/delivery/{deliveryId}")
	public ResponseEntity<Delivery> getDeliveryById(@PathVariable Integer deliveryId){
		try {
			Delivery delivery = deliveryService.findByPk(deliveryId);
			return new ResponseEntity<>(delivery,HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Shishir
	 * @return all deliveries
	 */
	@GetMapping("/delivery")
	public ResponseEntity<List<Delivery>> getAllDeliveries(){
		try {
			List<Delivery> deliveryList = deliveryService.search();
			return new ResponseEntity<>(deliveryList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Shishir
	 * @param pageNo
	 * @param pageSize
	 * @return deliveries of the pageNo with pageSize
	 */
	@GetMapping("/delivery/{pageNo}/{pageSize}")
	public ResponseEntity<List<Delivery>> getDeliveries(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		try {
			List<Delivery> deliveryList = deliveryService.search(pageNo, pageSize);
			return new ResponseEntity<>(deliveryList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Shishir
	 * @param Delivery
	 * @return adds delivery
	 */
	@PostMapping("/delivery")
	public ResponseEntity<Integer> addDelivery(@RequestBody Delivery delivery) {
		try {
			Integer deliveryId = deliveryService.addDelivery(delivery);
			return new ResponseEntity<>(deliveryId,HttpStatus.OK);
		}catch(DuplicateRecordException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Shishir
	 * @param delivery
	 * @return updating delivery
	 */
	@PutMapping("/delivery")
	public ResponseEntity<String> updateDelivery(@RequestBody Delivery delivery) {
		try {
			deliveryService.updateDelivery(delivery);
			return new ResponseEntity<>("updated successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Shishir
	 * @param delivery
	 * @return deleting delivery
	 */
	@DeleteMapping("/delivery")
	public ResponseEntity<String> deleteDelivery(@RequestBody Delivery delivery) {
		try {
			deliveryService.deleteDelivery(delivery);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	@Autowired
	private DomesticHelpService domesticHelpService;
	
	/**
	 * @author Harsh
	 * @param helpId
	 * @return Help
	 */
	@GetMapping("/domesticHelp/{helpId}")
	public ResponseEntity<DomesticHelp> getDomesticHelpById(@PathVariable Integer helpId){
		try {
			DomesticHelp domesticHelp = domesticHelpService.findByPk(helpId);
			return new ResponseEntity<>(domesticHelp,HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Harsh
	 * @return all helps
	 */
	@GetMapping("/domesticHelp")
	public ResponseEntity<List<DomesticHelp>> getAllHelps(){
		try {
			List<DomesticHelp> helpList = domesticHelpService.search();
			return new ResponseEntity<>(helpList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Harsh
	 * @param pageNo
	 * @param pageSize
	 * @return helps of the pageNo with pageSize
	 */
	@GetMapping("/domesticHelp/{pageNo}/{pageSize}")
	public ResponseEntity<List<DomesticHelp>> getHelps(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		try {
			List<DomesticHelp> helpList = domesticHelpService.search(pageNo, pageSize);
			return new ResponseEntity<>(helpList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Harsh
	 * @param DomesticHelp
	 * @return adds domesticHelp
	 */
	@PostMapping("/domesticHelp")
	public ResponseEntity<Integer> addHelp(@RequestBody DomesticHelp domesticHelp) {
		try {
			Integer helpId = domesticHelpService.addDomesticHelp(domesticHelp);
			return new ResponseEntity<>(helpId,HttpStatus.OK);
		}catch(DuplicateRecordException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Harsh
	 * @param DomesticHelp
	 * @return updating DomesticHelp
	 */
	@PutMapping("/domesticHelp")
	public ResponseEntity<String> updateHelp(@RequestBody DomesticHelp domesticHelp) {
		try {
			domesticHelpService.updateDomesticHelp(domesticHelp);
			return new ResponseEntity<>("updated successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Harsh
	 * @param DomesticHelp
	 * @return deleting DomesticHelp
	 */
	@DeleteMapping("/domesticHelp")
	public ResponseEntity<String> deleteHelp(@RequestBody DomesticHelp domesticHelp) {
		try {
			domesticHelpService.deleteDomesticHelp(domesticHelp);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	
	
	@Autowired
	private VisitorService visitorService;
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param VisitorId
	 * @return Visitor
	 */
	@GetMapping("/visitor/{visitorId}")
	public ResponseEntity<Visitor> getVisitorById(@PathVariable Integer visitorId){
		try {
			Visitor visitor = visitorService.findByPk(visitorId);
			return new ResponseEntity<>(visitor,HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Ram Sai Vajrapu
	 * @return all visitors
	 */
	@GetMapping("/visitor")
	public ResponseEntity<List<Visitor>> getAllVisitors(){
		try {
			List<Visitor> visitorList = visitorService.search();
			return new ResponseEntity<>(visitorList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param pageNo
	 * @param pageSize
	 * @return Visitor of the pageNo with pageSize
	 */
	@GetMapping("/visitor/{pageNo}/{pageSize}")
	public ResponseEntity<List<Visitor>> getVisitors(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		try {
			List<Visitor> visitorList = visitorService.search(pageNo, pageSize);
			return new ResponseEntity<>(visitorList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param Visitor
	 * @return adds Visitor
	 */
	@PostMapping("/visitor")
	public ResponseEntity<Integer> addVisitor(@RequestBody Visitor visitor) {
		try {
			Integer visitorId = visitorService.addVisitor(visitor);
			return new ResponseEntity<>(visitorId,HttpStatus.OK);
		}catch(DuplicateRecordException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param Visitor
	 * @return updating Visitor
	 */
	@PutMapping("/visitor")
	public ResponseEntity<String> updateVisitor(@RequestBody Visitor visitor) {
		try {
			visitorService.updateVisitor(visitor);
			return new ResponseEntity<>("updated successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param Visitor
	 * @return deleting Visitor
	 */
	@DeleteMapping("/visitor")
	public ResponseEntity<String> deleteVisitor(@RequestBody Visitor visitor) {
		try {
			visitorService.deleteVisitor(visitor);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	
	
	@Autowired
	private VehicleService vehicleService;
	
	/**
	 * @author Devarshi
	 * @param VehicleId
	 * @return Vehicle
	 */
	@GetMapping("/vehicle/{vehicleId}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable String vehicleId){
		try {
			Vehicle vehicle = vehicleService.findByPk(vehicleId);
			return new ResponseEntity<>(vehicle,HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Devarshi
	 * @return all Vehicles
	 */
	@GetMapping("/vehicle")
	public ResponseEntity<List<Vehicle>> getAllVehicles(){
		try {
			List<Vehicle> vehicleList = vehicleService.search();
			return new ResponseEntity<>(vehicleList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Devarshi
	 * @param pageNo
	 * @param pageSize
	 * @return Vehicle of the pageNo with pageSize
	 */
	@GetMapping("/vehicle/{pageNo}/{pageSize}")
	public ResponseEntity<List<Vehicle>> getVehicles(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		try {
			List<Vehicle> vehicleList = vehicleService.search(pageNo, pageSize);
			return new ResponseEntity<>(vehicleList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Devarshi
	 * @param vehicle
	 * @return adds vehicle
	 */
	@PostMapping("/vehicle")
	public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
		try {
			String vehicleId = vehicleService.addVehicle(vehicle);
			return new ResponseEntity<>(vehicleId,HttpStatus.OK);
		}catch(DuplicateRecordException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Devarshi
	 * @param vehicle
	 * @return updating vehicle
	 */
	@PutMapping("/vehicle")
	public ResponseEntity<String> updateVehicle(@RequestBody Vehicle vehicle) {
		try {
			vehicleService.updateVehicle(vehicle);
			return new ResponseEntity<>("updated successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Devarshi
	 * @param vehicle
	 * @return deleting vehicle
	 */
	@DeleteMapping("/vehicle")
	public ResponseEntity<String> deleteVehicle(@RequestBody Vehicle vehicle) {
		try {
			vehicleService.deleteVehicle(vehicle);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
