package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.aps.dao.VisitorDAO;
import com.cg.aps.entity.Visitor;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
/**
 * 
 * @author Ram Sai Vajrapu
 * class for implementing visitor service layer interface
 *
 */
@Service
@Transactional
public class VisitorServiceImpl implements VisitorService{

	@Autowired
	private VisitorDAO visitorDao;
	
	@Override
	public Integer addVisitor(Visitor visitor) throws DuplicateRecordException {
		try {			
			visitorDao.save(visitor);
			return visitor.getVisitorId();
		}catch(DataAccessException e) {
			throw new DuplicateRecordException(e.getMessage());
		}catch(Exception e) {
			throw new DuplicateRecordException(e.getMessage());
		}
	}

	@Override
	public void updateVisitor(Visitor visitor) throws RecordNotFoundException {
		try {			
			visitorDao.save(visitor);
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
		
	}

	@Override
	public void deleteVisitor(Visitor visitor) throws RecordNotFoundException {
		try {			
			visitorDao.delete(visitor);
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public Visitor findByPk(Integer id) throws RecordNotFoundException {
		try {			
			Optional<Visitor> optional = visitorDao.findById(id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid id");
			}
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Visitor> search(Integer pageNo, Integer pageSize) throws DatabaseException {
		try {	
			PageRequest paging = PageRequest.of(pageNo, pageSize);
			Page<Visitor> pagedResult = visitorDao.findAll(paging);
			if(pagedResult.hasContent()) {
				return pagedResult.getContent();
			}else {
				throw new Exception("Invalid pageNo and pageSize");
			}
		}catch(DataAccessException e) {
			throw new DatabaseException(e.getMessage());
		}catch(Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Override
	public List<Visitor> search() throws DatabaseException {
		try {			
			return visitorDao.findAll();
		}catch(DataAccessException e) {
			throw new DatabaseException(e.getMessage());
		}catch(Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	/*@Override
	public List<Visitor> findByName(String name) throws RecordNotFoundException {
		try {			
			return visitorDao.findByName(name);
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}*/

}
