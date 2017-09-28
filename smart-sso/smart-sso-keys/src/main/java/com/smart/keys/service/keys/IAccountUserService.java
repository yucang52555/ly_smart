package com.smart.keys.service.keys;

import com.smart.keys.model.bo.wechat.WechatUserInfoBo;
import com.smart.keys.model.po.AccountUser;
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
	 * @throws BusinessException2
	 */
	public void save(AccountUser accountUser) throws BusinessException;

	/**
	 * 保存或更新微信用户信息
	 * @param userInfoBo
	 */
	public AccountUser saveOrUpdateWechatUserInfo(WechatUserInfoBo userInfoBo) throws BusinessException;
}
