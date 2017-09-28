package com.smart.keysadmin.dao;

import java.util.List;

import com.smart.keysadmin.model.param.AccountUserQueryParam;
import com.smart.keysadmin.model.po.AccountUser;
import com.smart.mvc.dao.mybatis.Dao;

public interface AccountUserMapper extends Dao<AccountUser, Integer> {
    int deleteByPrimaryKey(Long id);

    int insert(AccountUser record);

    int insertSelective(AccountUser record);

    AccountUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountUser record);

    int updateByPrimaryKey(AccountUser record);

	AccountUser findUserByOpenId(String wechatOpenId);

	List<AccountUser> selectListBySearchContent(AccountUserQueryParam accountUserQueryParam);

}