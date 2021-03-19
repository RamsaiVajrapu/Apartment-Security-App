package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.Visitor;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
/**
 * 
 * @author Ram Sai Vajrapu
 * interface of visitor in service layer
 *
 */
public interface VisitorService {

	public Integer addVisitor(Visitor visitor) throws DuplicateRecordException;
	public void updateVisitor(Visitor visitor) throws RecordNotFoundException;
	public void deleteVisitor(Visitor visitor) throws RecordNotFoundException;
	public List<Visitor> findByVisitorName(String name) throws RecordNotFoundException;
	public Visitor findByPk(Integer id) throws RecordNotFoundException;
	public List<Visitor> search(Integer pageNo, Integer pageSize) throws DatabaseException;
	public List<Visitor> search() throws DatabaseException;
}
