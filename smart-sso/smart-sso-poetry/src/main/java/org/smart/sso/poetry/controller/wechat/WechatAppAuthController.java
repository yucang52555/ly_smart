package org.smart.sso.poetry.controller.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.sso.poetry.model.bo.wechat.WechatAppAssessTokenBo;
import org.smart.sso.poetry.service.wechat.IWechatAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/app/auth")
public class WechatAppAuthController {
	/**
     * 日志对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(WechatAppAuthController.class);

    @Autowired
    IWechatAuthService wechatAuthService;

	@ApiOperation("获取微信小程序accessToken")
  	@RequestMapping(value = "/getAppAccessToken", method = RequestMethod.GET)
  	public @ResponseBody Result getAppAccessToken(@ApiParam(value = "token", required = true) @ValidateParam({ Validator.NOT_BLANK }) String token) {
		LOG.info("获取微信小程序accessToken");
		WechatAppAssessTokenBo appAssessTokenBo = wechatAuthService.getAppAccessToken();
		return Result.createSuccessResult().setData(appAssessTokenBo);
  	}
	
	@ApiOperation("获取微信小程序码")
  	@RequestMapping(value = "/getAppWXacode", method = RequestMethod.GET)
  	public @ResponseBody Result getAppWXacode(@ApiParam(value = "token", required = true) @ValidateParam({ Validator.NOT_BLANK }) String token) {
		LOG.info("获取微信小程序accessToken");
		WechatAppAssessTokenBo appAssessTokenBo = null;
		wechatAuthService.getAppWXacode();
		return Result.createSuccessResult().setData(appAssessTokenBo);
  	}
}
