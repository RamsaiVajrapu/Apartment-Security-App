package com.cg.aps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.aps.entity.User;

public interface UserDAO extends JpaRepository<User,Integer> {

}
