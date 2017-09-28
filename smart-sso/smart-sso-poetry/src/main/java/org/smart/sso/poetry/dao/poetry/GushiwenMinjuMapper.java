package org.smart.sso.poetry.dao.poetry;

import org.smart.sso.poetry.model.po.poetry.Minju;

public interface GushiwenMinjuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Minju record);

    int insertSelective(Minju record);

    Minju selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Minju record);

    int updateByPrimaryKey(Minju record);

	Integer selectTotalMinjuCount();

	Minju selectByOrderId(Integer orderId);

	Minju selectRecommendNextByMinjuId(Integer minjuId);
}