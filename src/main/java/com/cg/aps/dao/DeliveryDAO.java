package com.cg.aps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.aps.entity.Delivery;

public interface DeliveryDAO extends JpaRepository<Delivery,Integer> {

}
