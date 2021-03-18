package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.User;
import com.cg.aps.exception.ApplicationException;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public class UserServiceImpl implements UserService{

	@Override
	public Integer addUser(User user) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByLogin(String login) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByPk(Integer id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> search(Long pageNo, Integer pageSize) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> search() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User authenticate(User user) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean changePassword(Integer id, String oldPassword, String newPassword) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer registerUser(User user) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean forgetPassword(String login) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
