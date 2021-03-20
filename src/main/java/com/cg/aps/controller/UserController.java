package com.cg.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.aps.entity.Guard;
import com.cg.aps.entity.Owner;
import com.cg.aps.entity.User;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.service.GuardService;
import com.cg.aps.service.OwnerService;
import com.cg.aps.service.UserService;

import io.swagger.annotations.Api;
/**
 * 
 * @author Vikas
 *
 */
@Api
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private GuardService guardService;
	 
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> userList = userService.search();
			return new ResponseEntity<>(userList, HttpStatus.OK);
		}catch(DatabaseException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@PostMapping("/users")
	public ResponseEntity<Integer> addUser(@RequestBody User user) {
		try {
			Integer userId = userService.addUser(user);	
			if(user.getRole().toLowerCase().equals("owner")) {
				Owner owner = new Owner();
				owner.setOwnerId(user.getUserId());
				owner.setOwnerName(user.getName());
				owner.setEmailId(user.getEmailId());
				owner.setMobileNo(user.getMobileNo());
				ownerService.addOwner(owner);
			}else if(user.getRole().toLowerCase().equals("guard")) {
				Guard guard = new Guard();
				guard.setGuardId(user.getUserId());
				guard.setGuardName(user.getName());
				guard.setEmailId(user.getEmailId());
				guard.setMobileNo(user.getMobileNo());
				guardService.addGuard(guard);
			}
			return new ResponseEntity<>(userId, HttpStatus.OK);
		}catch(DuplicateRecordException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
}
