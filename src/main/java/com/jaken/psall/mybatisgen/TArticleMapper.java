package com.jaken.psall.mybatisgen;

import com.jaken.psall.mybatisgen.TArticle;

public interface TArticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(TArticle record);

    int insertSelective(TArticle record);

    TArticle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TArticle record);

    int updateByPrimaryKeyWithBLOBs(TArticle record);

    int updateByPrimaryKey(TArticle record);
}