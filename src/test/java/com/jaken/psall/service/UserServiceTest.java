package com.jaken.psall.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaken.psall.config.RootConfig;
import com.jaken.psall.entity.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void selectAll(){
		List<User> users=userService.selectAll();
		for(User user:users){
			System.out.println(user.getName());
		}
	}
}
