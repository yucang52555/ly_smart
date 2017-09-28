package com.smart.keysadmin.service;

import java.util.List;

import com.smart.keysadmin.model.param.AccountUserQueryParam;
import com.smart.keysadmin.model.po.AccountUser;
import com.smart.mvc.exception.BusinessException;

/**
 * 用户服务
 * @author kangtiancheng
 * @date 2017年8月19日
 */
public interface IAccountUserService {
	/**
	 * 保存用户信息
	 * @param accountUser
	 * @throws BusinessException
	 */
	public void save(AccountUser accountUser) throws BusinessException;

	/**
	 * 查询用户信息列表
	 * @param accountUser
	 * @throws BusinessException
	 */
	public List<AccountUser> list(AccountUserQueryParam accountUserQueryParam) throws BusinessException;

	/**
	 * 删除账号信息
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	public Integer delete(Integer accountId) throws BusinessException;

}
