package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.Delivery;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public interface DeliveryService {

	public Integer addDelivery(Delivery delivery) throws DuplicateRecordException;
	public void updateDelivery(Delivery delivery) throws RecordNotFoundException;
	public void deleteDelivery(Delivery delivery) throws RecordNotFoundException;
	public Delivery findByPk(Integer id) throws RecordNotFoundException;
	public List<Delivery> search(Integer pageNo, Integer pageSize) throws DatabaseException;
	public List<Delivery> search() throws DatabaseException;
}
