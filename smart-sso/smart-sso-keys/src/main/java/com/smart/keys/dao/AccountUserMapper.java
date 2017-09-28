package com.smart.keys.dao;

import com.smart.keys.model.po.AccountUser;
import com.smart.mvc.dao.mybatis.Dao;

public interface AccountUserMapper extends Dao<AccountUser, Integer> {
    int deleteByPrimaryKey(Long id);

    int insert(AccountUser record);

    int insertSelective(AccountUser record);

    AccountUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountUser record);

    int updateByPrimaryKey(AccountUser record);

	AccountUser findUserByOpenId(String wechatOpenId);

}