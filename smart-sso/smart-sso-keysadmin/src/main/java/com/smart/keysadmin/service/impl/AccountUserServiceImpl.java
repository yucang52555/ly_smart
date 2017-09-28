package com.smart.keysadmin.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.keysadmin.dao.AccountUserMapper;
import com.smart.keysadmin.model.param.AccountUserQueryParam;
import com.smart.keysadmin.model.po.AccountUser;
import com.smart.keysadmin.service.IAccountUserService;
import com.smart.mvc.exception.BusinessException;

@Service("accountUserService")
public class AccountUserServiceImpl implements IAccountUserService {

	@Autowired
	AccountUserMapper accountUserMapper;

	@Override
	public void save(AccountUser accountUser) {
		accountUserMapper.insert(accountUser);
	}
	
	public static void main(String[] args) {
		String aaa = null;
		System.out.println(StringUtils.isBlank(aaa));
	}

	@Override
	public List<AccountUser> list(AccountUserQueryParam accountUserQueryParam) throws BusinessException {
		List<AccountUser> accountUsers = accountUserMapper.selectListBySearchContent(accountUserQueryParam);
		return accountUsers;
	}

	@Override
	public Integer delete(Integer accountId) throws BusinessException {
		return accountUserMapper.deleteByPrimaryKey(Long.valueOf(accountId));
	}

}
