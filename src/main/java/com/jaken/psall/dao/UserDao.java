package com.jaken.psall.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jaken.psall.entity.User;

@Repository("userDao")
public interface UserDao {

	public List<User> selectAll();
	
	public void addUser(User user);
}
