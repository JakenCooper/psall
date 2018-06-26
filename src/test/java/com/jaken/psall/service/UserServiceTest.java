package com.jaken.psall.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaken.psall.config.RootConfig;
import com.jaken.psall.entity.Category;
import com.jaken.psall.entity.User;
import com.jaken.psall.util.Des;
import com.jaken.psall.util.PsallUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
//	@Test
	public void testenv(){
		userService.testenv();
	}
	
//	@Test
	public void adduser(){
		User user = new User();
		user.setId(PsallUtil.genUUID());
		user.setName("Jaken");
		user.setPasswd(Des.encrypt("jaken123"));
		userService.addUser(user);
	}
	
//	@Test
	public void selectuser(){
		String id = "ca656421-a001-4382-8e38-d766f62a2250";
		User user = userService.getUser(id);
		System.out.println(user.getId()+" --- "+user.getName()+" --- "+user.getAge());
		User user1 = userService.getUserMy(id);
		System.out.println(user1.getId()+" --- "+user1.getName()+" --- "+user1.getAge());
	}
	
	@Test
	public void selectuserallusingmybatis(){
		String id = "ca656421-a001-4382-8e38-d766f62a2250";
		User user = userService.getUserMy(id);
		System.out.println(user.getId()+" --- "+user.getName()+" --- "+user.getAge());
		List<Category> categories = user.getCategories();
		if(categories!=null){
			for(Category cat:categories){
				System.out.println(cat.getId()+" === "+cat.getName()+" === "+cat.getUserId());
			}
		}
	}
	
}
