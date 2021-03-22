package com.cg.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.cg.aps.application.ApartmentSecurityAppApplication;
import com.cg.aps.entity.User;
import com.cg.aps.exception.ApplicationException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.UserService;

@SpringBootTest(classes = ApartmentSecurityAppApplication.class)
@Transactional
@Rollback(true)
public class UserTest {

	@Autowired
	private UserService userService;
	
	public User addUser() throws DuplicateRecordException, RecordNotFoundException {
		User user = new User();
		user.setUserId(1004);
		user.setName("Ramsai");
		user.setEmailId("rockstar@fun.com");
		user.setMobileNo(9012345678L);
		user.setRole("owner");
		user.setPassword("root");
		Integer id = userService.addUser(user);
		return userService.findByPk(id);
	} 
	
	/*
	 * check add user
	 */
	@Test
	public void testAddUser() throws DuplicateRecordException, RecordNotFoundException {
		User user = addUser();
		assertEquals(1004, user.getUserId());
		assertNotEquals("xyz",user.getName());
		assertEquals(9012345678L,user.getMobileNo());
		assertNotEquals("anna@gmail.com",user.getEmailId());
		assertEquals("owner",user.getRole());
	}
	
	/*
	 * check edit user
	 */
	@Test
	public void testEditUser() throws DuplicateRecordException, RecordNotFoundException {
		User user = addUser();
		user.setName("Harsh Agarwal");
		user.setEmailId("harsh@agarwal.com");
		userService.updateUser(user);
		assertNotEquals("Ramsai",userService.findByPk(user.getUserId()).getName());
		assertEquals("harsh@agarwal.com",userService.findByPk(user.getUserId()).getEmailId());
	}
	
	/*
	 * check change password of user
	 */
	@Test
	public void testChangeUserPassword() throws DuplicateRecordException, RecordNotFoundException, ApplicationException {
		User user = addUser();
		String newPassword = "password";
		Boolean check = userService.changePassword(user.getUserId(), user.getPassword(), newPassword);
		assertTrue(check);
	}
	
	
	/*
	 * check delete owner
	 */
	@Test
	public void testDeleteUser() throws DuplicateRecordException, RecordNotFoundException {
		User user = addUser();
		userService.deleteUser(user);
		assertThrows(RecordNotFoundException.class, ()->{
			userService.findByPk(user.getUserId());
			});
	}
}
