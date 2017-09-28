package com.smart.sso.server.dao.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smart.mvc.dao.mybatis.Dao;
import com.smart.mvc.model.Pagination;
import com.smart.sso.server.model.po.base.Img;

/**
 * 图片持久化接口
 * @author kangtiancheng
 * @date 2017年5月17日
 */
public interface ImgDao extends Dao<Img, Integer> {
	
	public List<Img> findPaginationByName(@Param("name") String name, Pagination<Img> p);
	
	public Img findByCode(@Param("imgCode") String imgCode);
	
}
