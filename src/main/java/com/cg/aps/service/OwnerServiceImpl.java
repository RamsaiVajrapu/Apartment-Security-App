package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.Owner;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public class OwnerServiceImpl implements OwnerService{

	@Override
	public Integer addOwner(Owner owner) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOwner(Owner owner) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOwner(Owner owner) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Owner findByPk(Integer id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Owner> search(Long pageNo, Integer pageSize) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Owner> search() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
