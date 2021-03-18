package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.SecurityAlert;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public interface SecurityAlertService {

	public Integer addSecurityAlert(SecurityAlert securityAlert) throws DuplicateRecordException;
	public void updateSecurityAlert(SecurityAlert securityAlert) throws RecordNotFoundException;
	public void deleteSecurityAlert(SecurityAlert securityAlert) throws RecordNotFoundException;
	public SecurityAlert findByPk(Integer id) throws RecordNotFoundException;
	public List<SecurityAlert> search(Long pageNo, Integer pageSize) throws DatabaseException;
	public List<SecurityAlert> search() throws DatabaseException;
}
