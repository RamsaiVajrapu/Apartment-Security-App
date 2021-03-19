package com.cg.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.aps.entity.Owner;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.OwnerService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/api/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	/*
	 * @GetMapping("/owners/{ownerId}") public ResponseEntity<Owner>
	 * getOwnerById(@PathVariable Integer ownerId){ try { Owner owner =
	 * ownerService.findByPk(ownerId); return new ResponseEntity<>(owner,
	 * HttpStatus.OK); }catch(RecordNotFoundException e) { throw new
	 * ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); }
	 * 
	 * }
	 * 
	 * @GetMapping("/owners") public ResponseEntity<List<Owner>> getAllOwners(){ try
	 * { List<Owner> ownerList = ownerService.search(); return new
	 * ResponseEntity<>(ownerList, HttpStatus.OK); }catch(DatabaseException e) {
	 * throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); } }
	 * 
	 * @PostMapping("/owners") public ResponseEntity<Integer> addOwner(@RequestBody
	 * Owner owner) { try { Integer ownerId= ownerService.addOwner(owner); return
	 * new ResponseEntity<>(ownerId, HttpStatus.OK); }catch(DuplicateRecordException
	 * e) { throw new
	 * ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); } }
	 */
	
}
