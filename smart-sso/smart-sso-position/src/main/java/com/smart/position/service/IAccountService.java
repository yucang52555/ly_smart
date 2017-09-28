package com.smart.position.service;

import java.util.List;

import com.smart.mvc.model.Pagination;
import com.smart.position.model.po.Account;

/**
 * 账号服务
 * @author kangtiancheng
 * @date 2017年6月7日
 */
public interface IAccountService {

	/**
	 * 获取账号
	 * @param id
	 * @return
	 */
	Account get(Integer id);

	/**
	 * 分页查询账号
	 * @param keyName
	 * @param pagination
	 * @return
	 */
	Pagination<Account> findPaginationByAccount(String keyName, Pagination<Account> pagination);

	/**
	 * 保存产品
	 * @param product
	 * @return
	 */
	void save(Account account);

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
	public List<Account> findByAll(String name);

	
}
