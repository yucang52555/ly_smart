package com.smart.keys.service.wechat;

import com.smart.keys.model.bo.wechat.WechatAppAssessTokenBo;
import com.smart.keys.model.bo.wechat.WechatAssessTokenBo;
import com.smart.keys.model.bo.wechat.WechatUserInfoBo;
import com.smart.mvc.exception.BusinessException;

/**
 * 微信公众平台访问权限相关服务
 * @author kangtiancheng
 * @date 2017年7月8日
 */
public interface IWechatAuthService {

	/**
	 * 获取微信公众号accessToken
	 * @return
	 */
	WechatAssessTokenBo getAssessToken();

	/**
	 * 获取微信公众平台accessToken
	 * @return
	 */
	WechatAppAssessTokenBo getAppAccessToken();

	/**
	 * 获取微信小程序码
	 * @return 
	 */
	String getAppWXacode();

	/**
	 * 获取微信登录用户信息
	 * @param code
	 * @return
	 * @throws BusinessException2 
	 */
	WechatUserInfoBo getWxAppUserInfo(String code) throws BusinessException;
	
}
