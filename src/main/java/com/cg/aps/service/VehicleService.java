package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.Vehicle;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
/**
 * 
 * @author Devarshi
 * Vehicle service layer interface
 *
 */
public interface VehicleService {

	public String addVehicle(Vehicle vehicle) throws DuplicateRecordException;
	public void updateVehicle(Vehicle vehicle) throws RecordNotFoundException;
	public void deleteVehicle(Vehicle vehicle) throws RecordNotFoundException;
	public Vehicle findByPk(String id) throws RecordNotFoundException;
	public List<Vehicle> search(Integer pageNo, Integer pageSize) throws DatabaseException;
	public List<Vehicle> search() throws DatabaseException;
}
