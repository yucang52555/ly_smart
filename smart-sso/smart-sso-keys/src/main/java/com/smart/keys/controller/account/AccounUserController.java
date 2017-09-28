package com.smart.keys.controller.account;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.keys.model.bo.wechat.WechatUserInfoBo;
import com.smart.keys.model.param.WechatUserInfoParam;
import com.smart.keys.model.po.AccountUser;
import com.smart.keys.service.keys.IAccountUserService;
import com.smart.keys.service.wechat.IWechatAuthService;
import com.smart.mvc.exception.BusinessException;
import com.smart.mvc.model.Result;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 公众号小程序权限
 * @author kangtiancheng
 * @date 2017年8月5日
 */
@Controller
@RequestMapping("/account/user")
public class AccounUserController {
	/**
     * 日志对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(AccounUserController.class);

    @Autowired
    IAccountUserService accountUserService;
    
    @Autowired
    IWechatAuthService wechatAuthService;

	@ApiOperation("保存小程序用户信息")
  	@RequestMapping(value = "/saveOrUpdateUserInfo", method = RequestMethod.POST)
  	public @ResponseBody Result saveOrUpdateUserInfo(@ApiParam(value = "wechatUserInfo", required = true) @ValidateParam({ Validator.NOT_BLANK }) WechatUserInfoParam wechatUserInfo) {
		LOG.info("保存小程序用户信息" + wechatUserInfo.toString());
		AccountUser data = null;
		try {
			if (StringUtils.isBlank(wechatUserInfo.getWechatOpenId()) || StringUtils.equals("null", wechatUserInfo.getWechatOpenId()) || 
					StringUtils.equals("undefined", wechatUserInfo.getWechatOpenId())) {
				wechatUserInfo.setWechatOpenId(wechatAuthService.getWxAppUserInfo(wechatUserInfo.getCode()).getWechatOpenId());
			}
			WechatUserInfoBo userInfoBo = new WechatUserInfoBo(wechatUserInfo);
			data = accountUserService.saveOrUpdateWechatUserInfo(userInfoBo);
		} catch (BusinessException e) {
			return Result.createSuccessResult().setMessage(e.getMessage());
		}
		return Result.createSuccessResult().setData(data);
  	}
}
