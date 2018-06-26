package com.jaken.psall.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaken.psall.dao.UserDao;
import com.jaken.psall.dao.UserDaoMy;
import com.jaken.psall.entity.User;

@Service
@PropertySource("classpath:psall.properties")
@Transactional(value="jpaTransactionManager")
public class UserService {

	@Autowired
	private Environment env;
	@Value("${jdbc.user}")
	private String jdbcUser;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserDaoMy userDaoMy;
	
	public void testenv(){
		System.out.println("encryed values ===== "+env.getProperty("jdbc.url")+" --- "+env.getProperty("jdbc.user"));
		System.out.println("encryped user name ======== "+jdbcUser);
	}
	
	
	public void addUser(User user){
		userDao.save(user);
		System.out.println("1111111111111111");
		User user1 = getUser(user.getId());
		System.out.println(user1.getId()+" --- "+user1.getName()+" --- "+user1.getAge());
	}
	
	public User getUser(String id){
		return userDao.findById(id);
	}
	
	@Transactional("dataSourceTransactionManager")
	public User getUserMy(String id){
		User user = userDaoMy.mybatisGetUserId(id);
		user.getCategories().toString();
		return user;
	}
}
