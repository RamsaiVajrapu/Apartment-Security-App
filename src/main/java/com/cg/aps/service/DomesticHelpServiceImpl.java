package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.DomesticHelp;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public class DomesticHelpServiceImpl implements DomesticHelpService{

	@Override
	public Integer addDomesticHelp(DomesticHelp domesticHelp) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDomesticHelp(DomesticHelp domesticHelp) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDomesticHelp(DomesticHelp domesticHelp) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DomesticHelp findByPk(Integer id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DomesticHelp> search(Long pageNo, Integer pageSize) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DomesticHelp> search() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
