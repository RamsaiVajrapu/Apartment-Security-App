package com.cg.aps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.aps.entity.Visitor;

public interface VisitorDAO extends JpaRepository<Visitor,Integer> {

}
