package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.SecurityAlert;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public class SecurityAlertServiceImpl implements SecurityAlertService{

	@Override
	public Integer addSecurityAlert(SecurityAlert securityAlert) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSecurityAlert(SecurityAlert securityAlert) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSecurityAlert(SecurityAlert securityAlert) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SecurityAlert findByPk(Integer id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecurityAlert> search(Long pageNo, Integer pageSize) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecurityAlert> search() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
