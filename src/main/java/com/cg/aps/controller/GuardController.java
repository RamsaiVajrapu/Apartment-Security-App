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
import com.cg.aps.entity.GuardShift;
import com.cg.aps.entity.SecurityAlert;
import com.cg.aps.entity.Visitor;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.DeliveryService;
import com.cg.aps.service.DomesticHelpService;
import com.cg.aps.service.GuardShiftService;
import com.cg.aps.service.SecurityAlertService;
import com.cg.aps.service.VisitorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * @author Naga Vishnu
 *
 */
@Api
@RestController
@RequestMapping("/api/guard")
public class GuardController {

	@Autowired
	private SecurityAlertService alertService;
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param alertId
	 * @return alert
	 */
	@ApiOperation(value = "Get security alert",
			response = SecurityAlert.class,
			tags = "get-alert",
			consumes = "alertId",
			httpMethod = "GET")
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
	@ApiOperation(value = "Get all security alerts",
			response = SecurityAlert.class,
			tags = "get-all-alert",
			httpMethod = "GET")
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
	@ApiOperation(value = "Get security alert by page no and page size",
			response = SecurityAlert.class,
			tags = "get-alerts",
			consumes = "page no and page size",
			httpMethod = "GET")
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
	@ApiOperation(value = "add security alert",
			response = Integer.class,
			tags = "add-alert",
			consumes = "security alert object",
			httpMethod = "POST")
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
	@ApiOperation(value = "update security alert",
			response = String.class,
			tags = "update-alert",
			consumes = "security alert object",
			httpMethod = "PUT")
	@PutMapping("/alert")
	public ResponseEntity<String> updateAlert(@RequestBody SecurityAlert securityAlert) {
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
	@ApiOperation(value = "delete security alert",
			response = String.class,
			tags = "delete-alert",
			consumes = "security alert object",
			httpMethod = "DELETE")
	@DeleteMapping("/alert")
	public ResponseEntity<String> deleteAlert(@RequestBody SecurityAlert securityAlert) {
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
	@ApiOperation(value = "get delivery by Id",
			response = Delivery.class,
			tags = "get-delivery",
			consumes = "deliveryId",
			httpMethod = "GET")
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
	@ApiOperation(value = "get all deliveries",
			response = Delivery.class,
			tags = "get-all-deliveries",
			httpMethod = "GET")
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
	@ApiOperation(value = "get deliveries by page no and page size",
			response = Delivery.class,
			tags = "get-delivery",
			consumes = "page no and page size",
			httpMethod = "GET")
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
	@ApiOperation(value = "add delivery",
			response = Integer.class,
			tags = "add-delivery",
			consumes = "delivery object",
			httpMethod = "POST")
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
	@ApiOperation(value = "update delivery",
			response = String.class,
			tags = "update-delivery",
			consumes = "delivery object",
			httpMethod = "PUT")
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
	@ApiOperation(value = "delete delivery",
			response = String.class,
			tags = "delete-delivery",
			consumes = "delivery object",
			httpMethod = "DELETE")
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
	@ApiOperation(value = "get domestic help by Id",
			response = DomesticHelp.class,
			tags = "get-help",
			consumes = "helpId",
			httpMethod = "GET")
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
	@ApiOperation(value = "get all domestic help",
			response = DomesticHelp.class,
			tags = "get-all-help",
			httpMethod = "GET")
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
	@ApiOperation(value = "get domestic help by page no and page size",
			response = DomesticHelp.class,
			tags = "get-help",
			consumes = "page no and page size",
			httpMethod = "GET")
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
	@ApiOperation(value = "add domestic help",
			response = Integer.class,
			tags = "add-help",
			consumes = "domestic help",
			httpMethod = "POST")
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
	@ApiOperation(value = "update domestic help",
			response = String.class,
			tags = "update-help",
			consumes = "domestic help",
			httpMethod = "PUT")
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
	@ApiOperation(value = "delete domestic help",
			response = String.class,
			tags = "delete-help",
			consumes = "domestic help",
			httpMethod = "DELETE")
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
	@ApiOperation(value = "get visitor by id",
			response = Visitor.class,
			tags = "get-visitor",
			consumes = "visitorId",
			httpMethod = "GET")
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
	@ApiOperation(value = "get all visitors",
			response = Visitor.class,
			tags = "get-all-visitor",
			httpMethod = "GET")
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
	@ApiOperation(value = "get visitors by page no and page size",
			response = Visitor.class,
			tags = "get-visitors",
			consumes = "page no and page size",
			httpMethod = "GET")
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
	@ApiOperation(value = "add visitor",
			response = Integer.class,
			tags = "add-visitor",
			consumes = "visitor object",
			httpMethod = "POST")
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
	@ApiOperation(value = "update visitor",
			response = String.class,
			tags = "update-visitor",
			consumes = "visitor object",
			httpMethod = "PUT")
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
	@ApiOperation(value = "delete visitor",
			response = String.class,
			tags = "delete-visitor",
			consumes = "visitor object",
			httpMethod = "DELETE")
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
	private GuardShiftService guardShiftService;
	
	/**
	 * @author Naga Vishnu
	 * @param GuardShiftId
	 * @return GuardShift
	 */
	@ApiOperation(value = "get guard shift by id",
			response = GuardShift.class,
			tags = "get-guardShift",
			consumes = "shiftId",
			httpMethod = "GET")
	@GetMapping("/guardShift/{shiftId}")
	public ResponseEntity<GuardShift> getGuardShiftById(@PathVariable Integer shiftId){
		try {
			GuardShift guardShift = guardShiftService.findByPk(shiftId);
			return new ResponseEntity<>(guardShift,HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Naga Vishnu
	 * @return all GuardShifts
	 */
	@ApiOperation(value = "get all guard shifts",
			response = GuardShift.class,
			tags = "get-all-guardShift",
			httpMethod = "GET")
	@GetMapping("/guardShift")
	public ResponseEntity<List<GuardShift>> getAllGuardShifts(){
		try {
			List<GuardShift> guardShiftList = guardShiftService.search();
			return new ResponseEntity<>(guardShiftList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Naga Vishnu
	 * @param pageNo
	 * @param pageSize
	 * @return GuardShift of the pageNo with pageSize
	 */
	@ApiOperation(value = "get guard shift by page no and page size",
			response = GuardShift.class,
			tags = "get-guardShift",
			consumes = "page no and page size",
			httpMethod = "GET")
	@GetMapping("/guardShift/{pageNo}/{pageSize}")
	public ResponseEntity<List<GuardShift>> getGuardShifts(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		try {
			List<GuardShift> guardShiftList = guardShiftService.search(pageNo, pageSize);
			return new ResponseEntity<>(guardShiftList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Naga Vishnu
	 * @param GuardShift
	 * @return adds GuardShift
	 */
	@ApiOperation(value = "add guard shift",
			response = Integer.class,
			tags = "add-guardShift",
			consumes = "guardShift object",
			httpMethod = "POST")
	@PostMapping("/guardShift")
	public ResponseEntity<Integer> addGuardShift(@RequestBody GuardShift guardShift) {
		try {
			Integer guardShiftId = guardShiftService.addGuardShift(guardShift);
			return new ResponseEntity<>(guardShiftId,HttpStatus.OK);
		}catch(DuplicateRecordException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Naga Vishnu
	 * @param GuardShift
	 * @return updating GuardShift
	 */
	@ApiOperation(value = "update guard shift",
			response = String.class,
			tags = "update-guardShift",
			consumes = "guardShift object",
			httpMethod = "PUT")
	@PutMapping("/guardShift")
	public ResponseEntity<String> updateGuardShift(@RequestBody GuardShift guardShift) {
		try {
			guardShiftService.updateGuardShift(guardShift);
			return new ResponseEntity<>("updated successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Naga Vishnu
	 * @param GuardShift
	 * @return deleting GuardShift
	 */
	@ApiOperation(value = "delete guard shift",
			response = String.class,
			tags = "delete-guardShift",
			consumes = "guardShift object",
			httpMethod = "DELETE")
	@DeleteMapping("/guardShift")
	public ResponseEntity<String> deleteGuardShift(@RequestBody GuardShift guardShift) {
		try {
			guardShiftService.deleteGuardShift(guardShift);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
}
