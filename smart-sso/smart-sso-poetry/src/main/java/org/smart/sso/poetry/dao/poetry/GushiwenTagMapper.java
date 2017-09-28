package org.smart.sso.poetry.dao.poetry;

import java.util.List;

import org.smart.sso.poetry.model.po.poetry.Tag;

public interface GushiwenTagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

	List<Tag> selectAllTags();
}