package org.smart.sso.poetry.service.wechat;

import org.smart.sso.poetry.model.bo.wechat.WechatAppAssessTokenBo;
import org.smart.sso.poetry.model.bo.wechat.WechatAssessTokenBo;

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
	
}
