package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.DomesticHelp;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public interface DomesticHelpService {

	public Integer addDomesticHelp(DomesticHelp domesticHelp) throws DuplicateRecordException;
	public void updateDomesticHelp(DomesticHelp domesticHelp) throws RecordNotFoundException;
	public void deleteDomesticHelp(DomesticHelp domesticHelp) throws RecordNotFoundException;
	public DomesticHelp findByName(String name) throws RecordNotFoundException;
	public DomesticHelp findByPk(Integer id) throws RecordNotFoundException;
	public List<DomesticHelp> search(Long pageNo, Integer pageSize) throws DatabaseException;
	public List<DomesticHelp> search() throws DatabaseException;
}
