package com.cg.aps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.aps.entity.Owner;

public interface OwnerDAO extends JpaRepository<Owner,Integer> {

}
