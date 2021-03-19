package com.cg.aps.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.Visitor;
/**
 * 
 * @author Ram Sai Vajrapu
 * visitor class repository
 *
 */
@Repository
public interface VisitorDAO extends JpaRepository<Visitor,Integer> {

	//@Query("select v from Visitor v where v.visitorName = :name")
	//public List<Visitor> findByName(String name) throws Exception;
}
