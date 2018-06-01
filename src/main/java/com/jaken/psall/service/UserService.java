package com.jaken.psall.service;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaken.psall.dao.UserDao;
import com.jaken.psall.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	private DataSource ds;
	
	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	private void checkDs(){
		if(this.ds==null){
			System.out.println("Datasource is blank!!!");
			return ;
		}
		BasicDataSource bds=(BasicDataSource)ds;
		String url=bds.getUrl();
		System.out.println("url============ "+url);
	}
	public List<User> selectAll(){
		checkDs();
		return userDao.selectAll();
	}
}
