package com.smart.product.service;

import java.util.List;

import com.smart.mvc.model.Pagination;
import com.smart.product.model.po.Product;

/**
 * 产品服务
 * @author kangtiancheng
 * @date 2017年5月19日
 */
public interface IProductService {

	/**
	 * 获取产品
	 * @param id
	 * @return
	 */
	Product get(Integer id);

	/**
	 * 分页查询产品
	 * @param account
	 * @param appId
	 * @param pagination
	 * @return
	 */
	Pagination<Product> findPaginationByProduct(String productName, Pagination<Product> pagination);

	/**
	 * 保存产品
	 * @param product
	 * @return
	 */
	void save(Product product);

	/**
	 * 删除产品
	 * @param idList 产品ID集合
	 * @return
	 */
	public void deleteById(List<Integer> idList);

	/**
	 * 根据名称查询
	 * @param name 产品名称
	 * @return
	 */
	public List<Product> findByAll(String name);

	
}
