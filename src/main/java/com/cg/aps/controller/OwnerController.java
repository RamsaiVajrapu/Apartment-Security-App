package com.cg.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cg.aps.entity.FlatDetails;
import com.cg.aps.entity.SecurityAlert;
import com.cg.aps.entity.Vehicle;
import com.cg.aps.entity.Visitor;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.DeliveryService;
import com.cg.aps.service.DomesticHelpService;
import com.cg.aps.service.FlatDetailsService;
import com.cg.aps.service.SecurityAlertService;
import com.cg.aps.service.VehicleService;
import com.cg.aps.service.VisitorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * @author Vedang
 *
 */
@Api
@RestController
@RequestMapping("/api/owner")
@CrossOrigin(origins = "http://localhost:3000")
public class OwnerController {

	@Autowired
	private SecurityAlertService alertService;
	
	/**
	 * @author Ram Sai Vajrapu
	 * @param alertId - id of alert
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
	 * @param pageNo - page number
	 * @param pageSize - page size
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
	 * @param securityAlert - alert object
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
	 * @param securityAlert - alert object
	 * @return updating alerts
	 */
	@ApiOperation(value = "update security alert",
			response = String.class,
			tags = "update-alert",
			consumes = "security alert object",
			httpMethod = "PUT")
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
	 * @param securityAlert - alert object
	 * @return deleting alert
	 */
	@ApiOperation(value = "delete security alert",
			response = String.class,
			tags = "delete-alert",
			consumes = "security alert object",
			httpMethod = "DELETE")
	@DeleteMapping("/alert/{id}")
	public ResponseEntity<String> deleteAlert(@PathVariable Integer id) {
		try {
			SecurityAlert alert = alertService.findByPk(id);
			alertService.deleteSecurityAlert(alert);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	
	
	@Autowired
	private DeliveryService deliveryService;
	
	
	/**
	 * @author Shishir
	 * @param deliveryId - id of delivery
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
	 * @param pageNo - page number
	 * @param pageSize - page size
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
	 * @param delivery - delivery object
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
	 * @param delivery - delivery object
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
	 * @param delivery - delivery object
	 * @return deleting delivery
	 */
	@ApiOperation(value = "delete delivery",
			response = String.class,
			tags = "delete-delivery",
			consumes = "delivery object",
			httpMethod = "DELETE")
	@DeleteMapping("/delivery/{id}")
	public ResponseEntity<String> deleteDelivery(@PathVariable Integer id) {
		try {
			Delivery delivery = deliveryService.findByPk(id);
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
	 * @param helpId - id of help
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
	 * @param pageNo - page number
	 * @param pageSize - page size
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
	 * @param domesticHelp - help object
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
	 * @param domesticHelp - help object
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
	 * @param domesticHelp - help object
	 * @return deleting DomesticHelp
	 */
	@ApiOperation(value = "delete domestic help",
			response = String.class,
			tags = "delete-help",
			consumes = "domestic help",
			httpMethod = "DELETE")
	@DeleteMapping("/domesticHelp/{id}")
	public ResponseEntity<String> deleteHelp(@PathVariable Integer id) {
		try {
			DomesticHelp domesticHelp = domesticHelpService.findByPk(id);
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
	 * @param visitorId - id of visitor
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
	 * @param pageNo - page number
	 * @param pageSize - page size
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
	 * @param visitor - visitor object
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
	 * @param visitor - visitor object
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
	 * @param visitor - visitor object
	 * @return deleting Visitor
	 */
	@ApiOperation(value = "delete visitor",
			response = String.class,
			tags = "delete-visitor",
			consumes = "visitor object",
			httpMethod = "DELETE")
	@DeleteMapping("/visitor/{id}")
	public ResponseEntity<String> deleteVisitor(@PathVariable Integer id) {
		try {
			Visitor visitor = visitorService.findByPk(id);
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
	 * @param vehicleId - id of vehicle
	 * @return Vehicle
	 */
	@ApiOperation(value = "get vehicle by id",
			response = Vehicle.class,
			tags = "get-vehicle",
			consumes = "vehicleId",
			httpMethod = "GET")
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
	@ApiOperation(value = "get all vehicle",
			response = Vehicle.class,
			tags = "get-all-vehicle",
			httpMethod = "GET")
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
	 * @param pageNo - page number
	 * @param pageSize - page size
	 * @return Vehicle of the pageNo with pageSize
	 */
	@ApiOperation(value = "get vehicles by page no and page size",
			response = Vehicle.class,
			tags = "get-vehicles",
			consumes = "page no and page size",
			httpMethod = "GET")
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
	 * @param vehicle - vehicle object
	 * @return adds vehicle
	 */
	@ApiOperation(value = "add vehicle",
			response = Integer.class,
			tags = "add-vehicle",
			consumes = "vehicle object",
			httpMethod = "POST")
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
	 * @param vehicle - vehicle object
	 * @return updating vehicle
	 */
	@ApiOperation(value = "update vehicle",
			response = String.class,
			tags = "update-vehicle",
			consumes = "vehicle object",
			httpMethod = "PUT")
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
	 * @param vehicle - vehicle object
	 * @return deleting vehicle
	 */
	@ApiOperation(value = "delete vehicle",
			response = String.class,
			tags = "delete-vehicle",
			consumes = "vehicle object",
			httpMethod = "DELETE")
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable String id) {
		try {
			Vehicle vehicle = vehicleService.findByPk(id);
			vehicleService.deleteVehicle(vehicle);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	
	
	@Autowired
	private FlatDetailsService flatDetailsService;
	
	/**
	 * @author Vedang
	 * @param flatDetailsId - id of flatdetails
	 * @return flatDetails
	 */
	@ApiOperation(value = "get flat details by id",
			response = FlatDetails.class,
			tags = "get-flatdetails",
			consumes = "flatDetailsId",
			httpMethod = "GET")
	@GetMapping("/flatDetails/{flatDetailsId}")
	public ResponseEntity<FlatDetails> getFlatDetailsById(@PathVariable Integer flatDetailsId){
		try {
			FlatDetails flatDetails = flatDetailsService.findByPk(flatDetailsId);
			return new ResponseEntity<>(flatDetails,HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @return all flatDetails
	 */
	@ApiOperation(value = "get all flat details",
			response = FlatDetails.class,
			tags = "get-all-flatdetails",
			httpMethod = "GET")
	@GetMapping("/flatDetails")
	public ResponseEntity<List<FlatDetails>> getAllFlatDetails(){
		try {
			List<FlatDetails> flatDetailsList = flatDetailsService.search();
			return new ResponseEntity<>(flatDetailsList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @param pageNo - page number
	 * @param pageSize - page size
	 * @return flatDetails of the pageNo with pageSize
	 */
	@ApiOperation(value = "get flat details by page no and page size",
			response = FlatDetails.class,
			tags = "get-flatdetails",
			consumes = "page no and page size",
			httpMethod = "GET")
	@GetMapping("/flatDetails/{pageNo}/{pageSize}")
	public ResponseEntity<List<FlatDetails>> getflatDetails(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		try {
			List<FlatDetails> flatDetailsList = flatDetailsService.search(pageNo, pageSize);
			return new ResponseEntity<>(flatDetailsList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @param flatDetails - flat object
	 * @return adds flatDetails
	 */
	@ApiOperation(value = "add flat details",
			response = Integer.class,
			tags = "add-flatdetails",
			consumes = "flatDetails object",
			httpMethod = "POST")
	@PostMapping("/flatDetails")
	public ResponseEntity<Integer> addFlatDetails(@RequestBody FlatDetails flatDetails) {
		try {
			Integer flatDetailsId = flatDetailsService.addFlatDetails(flatDetails);
			return new ResponseEntity<>(flatDetailsId,HttpStatus.OK);
		}catch(DuplicateRecordException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @param flatDetails - flat object
	 * @return updating flatDetails
	 */
	@ApiOperation(value = "update flat details",
			response = String.class,
			tags = "update-flatdetails",
			consumes = "flatDetails object",
			httpMethod = "PUT")
	@PutMapping("/flatDetails")
	public ResponseEntity<String> updateFlatDetails(@RequestBody FlatDetails flatDetails) {
		try {
			flatDetailsService.updateFlatDetails(flatDetails);
			return new ResponseEntity<>("updated successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @param flatDetails - flat object
	 * @return deleting flatDetails
	 */
	@ApiOperation(value = "delete flat details",
			response = String.class,
			tags = "delete-flatdetails",
			consumes = "flatDetails object",
			httpMethod = "DELETE")
	@DeleteMapping("/flatDetails/{id}")
	public ResponseEntity<String> deleteflatDetails(@PathVariable Integer id) {
		try {
			FlatDetails flatDetails = flatDetailsService.findByPk(id);
			flatDetailsService.deleteFlatDetails(flatDetails);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
