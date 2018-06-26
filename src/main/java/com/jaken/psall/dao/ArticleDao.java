package com.jaken.psall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jaken.psall.entity.Article;

@Repository("articleDao")
public interface ArticleDao extends JpaRepository<Article, String>,JpaSpecificationExecutor<Article>{

}
