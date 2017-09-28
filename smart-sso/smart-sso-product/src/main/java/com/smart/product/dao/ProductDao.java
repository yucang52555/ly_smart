package com.smart.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smart.mvc.dao.mybatis.Dao;
import com.smart.mvc.model.Pagination;
import com.smart.product.model.po.Product;

/**
 * 产品操作
 * @author kangtiancheng
 * @date 2017年5月17日
 */
public interface ProductDao extends Dao<Product, Integer> {
	
	public List<Product> findPaginationByName(@Param("productName") String productName, Pagination<Product> pagination);
	
	public Product findByCode(@Param("productCode") String productCode);

	public List<Product> findPaginationById(@Param("productCode") Integer productId);
	
}
