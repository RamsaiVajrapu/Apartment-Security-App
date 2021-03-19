package com.cg.aps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.SecurityAlert;
/**
 * 
 * @author Ram Sai Vajrapu
 * alerts repository
 *
 */
@Repository
public interface SecurityAlertDAO extends JpaRepository<SecurityAlert,Integer> {

}
