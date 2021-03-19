package com.cg.aps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.Vehicle;
/**
 * 
 * @author Devarshi
 * Vehicle entity's repository
 *
 */
@Repository
public interface VehicleDAO extends JpaRepository<Vehicle,String> {

}
