package org.smart.sso.poetry.dao.poetry;

import org.smart.sso.poetry.model.po.poetry.Author;

/**
 * 实时品类分布订单数据 DAO层
 * @since  2016年8月1日
 * @author ktc
 */
public interface GushiwenAuthorMapper {

	int deleteByPrimaryKey(Long id);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
}
