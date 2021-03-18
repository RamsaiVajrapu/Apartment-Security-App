package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.Vehicle;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public interface VehicleService {

	public Integer addVehicle(Vehicle vehicle) throws DuplicateRecordException;
	public void updateVehicle(Vehicle vehicle) throws RecordNotFoundException;
	public void deleteVehicle(Vehicle vehicle) throws RecordNotFoundException;
	public Vehicle findByPk(Integer id) throws RecordNotFoundException;
	public List<Vehicle> search(Long pageNo, Integer pageSize) throws DatabaseException;
	public List<Vehicle> search() throws DatabaseException;
}
