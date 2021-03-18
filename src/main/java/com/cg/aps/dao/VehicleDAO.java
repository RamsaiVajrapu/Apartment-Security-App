package com.cg.aps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.aps.entity.Vehicle;

public interface VehicleDAO extends JpaRepository<Vehicle,String> {

}
