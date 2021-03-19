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

import com.cg.aps.entity.User;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.UserService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	/*
	 * @Autowired private OwnerService ownerService;
	 */
	
	@PostMapping("/user")
	public ResponseEntity<Integer> addUser(@RequestBody User user) {
		try {
			Integer Id = userService.addUser(user);
			return new ResponseEntity<>(Id, HttpStatus.OK);
		}catch(DuplicateRecordException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> userList = userService.search();
			return new ResponseEntity<>(userList, HttpStatus.OK);
		}catch(DatabaseException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
}
