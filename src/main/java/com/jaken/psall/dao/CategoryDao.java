package com.jaken.psall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jaken.psall.entity.Category;

@Repository("categoryDao")
public interface CategoryDao extends JpaRepository<Category, String>,JpaSpecificationExecutor<Category>{

}
