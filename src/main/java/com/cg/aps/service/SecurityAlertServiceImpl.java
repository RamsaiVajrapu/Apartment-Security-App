package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.aps.dao.SecurityAlertDAO;
import com.cg.aps.entity.SecurityAlert;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
/**
 * 
 * @author Ram Sai Vajrapu
 * implementation class of SecurityAlert interface in service layer
 *
 */
@Service
@Transactional
public class SecurityAlertServiceImpl implements SecurityAlertService{

	@Autowired
	private SecurityAlertDAO securityAlertDao;
	
	@Override
	public Integer addSecurityAlert(SecurityAlert securityAlert) throws DuplicateRecordException {
		try {			
			securityAlertDao.save(securityAlert);
			return securityAlert.getId();
		}catch(DataAccessException e) {
			throw new DuplicateRecordException(e.getMessage());
		}catch(Exception e) {
			throw new DuplicateRecordException(e.getMessage());
		}
	}

	@Override
	public void updateSecurityAlert(SecurityAlert securityAlert) throws RecordNotFoundException {
		try {			
			securityAlertDao.save(securityAlert);
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
		
	}

	@Override
	public void deleteSecurityAlert(SecurityAlert securityAlert) throws RecordNotFoundException {
		try {			
			securityAlertDao.delete(securityAlert);
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
		
	}

	@Override
	public SecurityAlert findByPk(Integer id) throws RecordNotFoundException {
		try {			
			Optional<SecurityAlert> optional = securityAlertDao.findById(id);
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
	public List<SecurityAlert> search(Integer pageNo, Integer pageSize) throws DatabaseException {
		try {	
			PageRequest paging = PageRequest.of(pageNo, pageSize);
			Page<SecurityAlert> pagedResult = securityAlertDao.findAll(paging);
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
	public List<SecurityAlert> search() throws DatabaseException {
		try {			
			return securityAlertDao.findAll();
		}catch(DataAccessException e) {
			throw new DatabaseException(e.getMessage());
		}catch(Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}
