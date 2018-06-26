package com.jaken.psall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jaken.psall.entity.User;

@Repository("userDao")
public interface UserDao extends JpaRepository<User, String>,JpaSpecificationExecutor<User>{

	public User findById(String id);
	
}
