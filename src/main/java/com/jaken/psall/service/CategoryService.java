package com.jaken.psall.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaken.psall.dao.CategoryDao;
import com.jaken.psall.dao.CategoryDaoMy;
import com.jaken.psall.entity.Category;

@Service
@Transactional("jpaTransactionManager")
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private CategoryDaoMy categoryDaoMy;
	
	public void addCategoryBatch(List<Category> categories){
		for(Category category : categories){
			if(StringUtils.isBlank(category.getUserId())){
				throw new IllegalArgumentException("user id is empty");
			}
		}
		categoryDao.save(categories);
	}
	
	@Transactional("dataSourceTransactionManager")
	public Category getCategory(String id){
		Category category = categoryDaoMy.getCategory(id);
		category.getUser();
		return category;
	}
}
