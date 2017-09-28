package com.smart.keys.service.keys.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.keys.dao.AccountUserMapper;
import com.smart.keys.model.bo.wechat.WechatUserInfoBo;
import com.smart.keys.model.po.AccountUser;
import com.smart.keys.service.keys.IAccountUserService;
import com.smart.mvc.enums.ErrorType;
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
	public AccountUser saveOrUpdateWechatUserInfo(WechatUserInfoBo userInfoBo) throws BusinessException {
		if (StringUtils.isBlank(userInfoBo.getWechatOpenId()) || StringUtils.endsWith("null", userInfoBo.getWechatOpenId())) {
			throw new BusinessException(ErrorType.WX_APP_OPENID_IS_NULL);
		}
		AccountUser accountUser = accountUserMapper.findUserByOpenId(userInfoBo.getWechatOpenId());
		if (accountUser == null) {
			accountUser = new AccountUser(userInfoBo);
			accountUser.setCreateTime(new Date());
			accountUserMapper.insertSelective(accountUser);
		} else {
			accountUser = accountUser.initAccountUser(userInfoBo);
			accountUser.setUpdateTime(new Date());
			accountUserMapper.updateByPrimaryKeySelective(accountUser);
		}
		return accountUser;
	}

}
