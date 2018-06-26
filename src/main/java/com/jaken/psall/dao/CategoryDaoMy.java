package com.jaken.psall.dao;

import java.util.List;

import com.jaken.psall.entity.Category;

public interface CategoryDaoMy {

	public List<Category> getCategoriesByUserId(String userId);
	
	public Category getCategory(String id);
}
