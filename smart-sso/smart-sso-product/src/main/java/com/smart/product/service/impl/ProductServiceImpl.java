package com.smart.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.model.Pagination;
import com.smart.mvc.service.mybatis.impl.ServiceImpl;
import com.smart.product.dao.ProductDao;
import com.smart.product.model.po.Product;
import com.smart.product.service.IProductService;

@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product, Integer> implements IProductService {

	@Autowired
	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Product product) {
		dao.insert(product);
	}

	@Override
	public Pagination<Product> findPaginationByProduct(String productName, Pagination<Product> pagination) {
		dao.findPaginationByName(productName, pagination);
		return pagination;
	}

	@Override
	public List<Product> findByAll(String productName) {
		return dao.findPaginationByName(productName, null);
	}
}
