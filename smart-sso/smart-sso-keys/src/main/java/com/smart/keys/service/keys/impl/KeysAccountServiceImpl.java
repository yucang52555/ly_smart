package com.smart.keys.service.keys.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.keys.dao.AccountUserMapper;
import com.smart.keys.dao.KeysAccountMapper;
import com.smart.keys.model.po.AccountUser;
import com.smart.keys.model.po.KeysAccount;
import com.smart.keys.service.keys.IKeysAccountService;
import com.smart.mvc.enums.ErrorType;
import com.smart.mvc.exception.BusinessException;

@Service("keysAccountService")
public class KeysAccountServiceImpl implements IKeysAccountService {
	
	@Autowired
	KeysAccountMapper keysAccountMapper;
	
	@Autowired
	AccountUserMapper accountUserMapper;

	@Override
	public Integer saveKeysAccount(KeysAccount keysAccount, String wechatOpenId) throws BusinessException {
		Integer result = 0;
		if (StringUtils.isBlank(wechatOpenId) || StringUtils.endsWith("null", wechatOpenId)) {
			throw new BusinessException(ErrorType.WX_APP_OPENID_IS_NULL);
		}
		AccountUser accountUser = accountUserMapper.findUserByOpenId(wechatOpenId);
		if (accountUser != null) {
			if (keysAccount.getId() == null) {
				keysAccount.setUserId(accountUser.getId());
				keysAccount.setCreateTime(new Date());
				result = keysAccountMapper.insertSelective(keysAccount);
			} else {
				keysAccount.setUserId(accountUser.getId());
				keysAccount.setUpdateTime(new Date());;
				result = keysAccountMapper.updateByPrimaryKeySelective(keysAccount);
			}
			
		} else {
			throw new BusinessException(ErrorType.ACCOUNT_USER_NOT_EXIST);
		}
		return result;
	}

	@Override
	public List<KeysAccount> selectKeysAccountByOpenid(String wechatOpenId) throws BusinessException {
		AccountUser accountUser = accountUserMapper.findUserByOpenId(wechatOpenId);
		List<KeysAccount> keysAccounts = keysAccountMapper.selectKeysAccountByUserid(accountUser.getId());
		return keysAccounts;
	}

	@Override
	public KeysAccount getKeysAccount(Integer id) throws BusinessException {
		KeysAccount keysAccount = keysAccountMapper.selectByPrimaryKey(id);
		return keysAccount;
	}

	@Override
	public Integer deleteKeysAccount(Integer id) throws BusinessException {
		Integer result = keysAccountMapper.deleteByPrimaryKey(id);
		return result;
	}

	@Override
	public List<KeysAccount> selectKeysAccountByUserKeyWord(String wechatOpenId, String keyWord) throws BusinessException {
		AccountUser accountUser = accountUserMapper.findUserByOpenId(wechatOpenId);
		List<KeysAccount> keysAccounts = keysAccountMapper.selectKeysAccountByUserKeyWord(accountUser.getId(), keyWord);
		return keysAccounts;
	}

}
