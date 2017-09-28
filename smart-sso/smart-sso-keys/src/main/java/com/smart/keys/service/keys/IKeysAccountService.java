package com.smart.keys.service.keys;

import java.util.List;

import com.smart.keys.model.po.KeysAccount;
import com.smart.mvc.exception.BusinessException;

/**
 * 账号管理服务
 * @author kangtiancheng
 * @date 2017年9月1日
 */
public interface IKeysAccountService {
	/**
	 * 保存账号信息
	 * @param keysAccount
	 * @throws BusinessException2
	 */
	public Integer saveKeysAccount(KeysAccount keysAccount, String wechatOpenId) throws BusinessException;

	/**
	 * 根据openid查询账号信息列表
	 * @param openId
	 * @return
	 */
	public List<KeysAccount> selectKeysAccountByOpenid(String openId) throws BusinessException;
	
	/**
	 * 根据id查询账号详情
	 * @param openId
	 * @return
	 */
	public KeysAccount getKeysAccount(Integer id) throws BusinessException;

	/**
	 * 删除指定账号
	 * @param id
	 * @return
	 * @throws BusinessException2
	 */
	public Integer deleteKeysAccount(Integer id) throws BusinessException;

	/**
	 * 根据关键词查询用户账号列表
	 * @param wechatOpenId
	 * @param keyWord
	 * @return
	 */
	public List<KeysAccount> selectKeysAccountByUserKeyWord(String wechatOpenId, String keyWord) throws BusinessException;
}
