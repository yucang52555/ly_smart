package com.smart.position.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.model.Pagination;
import com.smart.mvc.service.mybatis.impl.ServiceImpl;
import com.smart.position.dao.AccountDao;
import com.smart.position.model.po.Account;
import com.smart.position.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account, Integer> implements IAccountService {

	@Autowired
	public void setDao(AccountDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Account account) {
		dao.insert(account);
	}

	@Override
	public Pagination<Account> findPaginationByAccount(String accountName, Pagination<Account> pagination) {
		dao.findPaginationByName(accountName, pagination);
		return pagination;
	}

	@Override
	public List<Account> findByAll(String accountName) {
		return dao.findPaginationByName(accountName, null);
	}
}
