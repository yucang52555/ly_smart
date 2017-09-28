package com.smart.keysadmin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smart.keysadmin.model.po.KeysAccount;

public interface KeysAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KeysAccount record);

    int insertSelective(KeysAccount record);

    KeysAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KeysAccount record);

    int updateByPrimaryKey(KeysAccount record);

    /**
     * 根据openid查询账号列表
     * @param openId
     * @return
     */
	List<KeysAccount> selectKeysAccountByUserid(Integer userId);

	/**
	 * 根据关键词查询账号列表
	 * @param id
	 * @param keyWord
	 * @return
	 */
	List<KeysAccount> selectKeysAccountByUserKeyWord(@Param(value = "userId")Integer userId, @Param(value = "keyWord")String keyWord);
}