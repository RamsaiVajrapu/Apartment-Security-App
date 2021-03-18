package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.Guard;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public class GuardServiceImpl implements GuardService{

	@Override
	public Integer addGuard(Guard guard) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGuard(Guard guard) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGuard(Guard guard) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Guard findByPk(Integer id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Guard> search(Long pageNo, Integer pageSize) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Guard> search() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
