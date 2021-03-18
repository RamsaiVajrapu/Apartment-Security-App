package com.cg.aps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.aps.entity.SecurityAlert;

public interface SecurityAlertDAO extends JpaRepository<SecurityAlert,Integer> {

}
