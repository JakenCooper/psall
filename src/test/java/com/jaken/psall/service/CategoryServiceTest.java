package com.jaken.psall.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaken.psall.config.RootConfig;
import com.jaken.psall.entity.Category;
import com.jaken.psall.entity.User;
import com.jaken.psall.util.PsallUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
public class CategoryServiceTest {

	@Autowired
	private CategoryService categoryService;
	
//	@Test
	public void addcategory(){
		String userId = "ca656421-a001-4382-8e38-d766f62a2250";
		Category cat1 = new Category(PsallUtil.genUUID(),"我的爱恋",userId,null);
		Category cat2 = new Category(PsallUtil.genUUID(),"喜欢小猫",userId,null);
		Category cat3 = new Category(PsallUtil.genUUID(),"小中中是猪猪",userId,null);
		List<Category> categories = new ArrayList<Category>();
		Collections.addAll(categories, cat1,cat2,cat3);
		categoryService.addCategoryBatch(categories);
	}
	
	@Test
	public void getcategory(){
		String catid="58cba828-01fe-41d5-ad89-4e978e03a70c";
		Category cat = categoryService.getCategory(catid);
		System.out.println(cat.getId()+" --- "+cat.getName());
		User user = cat.getUser();
		if(user!=null){
			System.out.println(user.getId()+" === "+user.getName()+" === "+user.getAge());
		}
	}
}
