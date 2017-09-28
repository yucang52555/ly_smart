package org.smart.sso.poetry.dao.poetry;

import org.smart.sso.poetry.model.po.poetry.Poetry;

public interface GushiwenPoetryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Poetry record);

    int insertSelective(Poetry record);

    Poetry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Poetry record);

    int updateByPrimaryKey(Poetry record);
}