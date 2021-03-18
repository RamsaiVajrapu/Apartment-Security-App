package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.Vehicle;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public class VehicleServiceImpl implements VehicleService{

	@Override
	public Integer addVehicle(Vehicle vehicle) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateVehicle(Vehicle vehicle) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVehicle(Vehicle vehicle) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Vehicle findByPk(Integer id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> search(Long pageNo, Integer pageSize) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> search() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
