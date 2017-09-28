package com.smart.position.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smart.mvc.dao.mybatis.Dao;
import com.smart.mvc.model.Pagination;
import com.smart.position.model.po.Account;

/**
 * 账号操作
 * @author kangtiancheng
 * @date 2017年6月7日
 */
public interface AccountDao extends Dao<Account, Integer> {
	
	public List<Account> findPaginationByName(@Param("accountName") String accountName, Pagination<Account> pagination);
	
	public Account findByCode(@Param("accountCode") String accountCode);

	public List<Account> findPaginationById(@Param("accountId") Integer accountId);
	
}
