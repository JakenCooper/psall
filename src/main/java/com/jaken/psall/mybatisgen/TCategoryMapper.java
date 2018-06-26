package com.jaken.psall.mybatisgen;

import com.jaken.psall.mybatisgen.TCategory;

public interface TCategoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(TCategory record);

    int insertSelective(TCategory record);

    TCategory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TCategory record);

    int updateByPrimaryKey(TCategory record);
}