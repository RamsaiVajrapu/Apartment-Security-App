package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.Visitor;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public class VisitorServiceImpl implements VisitorService{

	@Override
	public Integer addVisitor(Visitor visitor) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateVisitor(Visitor visitor) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVisitor(Visitor visitor) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Visitor findByPk(Integer id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visitor> search(Long pageNo, Integer pageSize) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visitor> search() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
