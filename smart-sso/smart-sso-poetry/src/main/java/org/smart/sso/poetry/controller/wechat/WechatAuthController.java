package org.smart.sso.poetry.controller.wechat;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.sso.poetry.model.bo.wechat.WechatAssessTokenBo;
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
 * 公众号权限
 * @author kangtiancheng
 * @date 2017年7月8日
 */
@Controller
@RequestMapping("{version:v1}/wechatAuth")
public class WechatAuthController {
    /**
     * 日志对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(WechatAuthController.class);

    @Autowired
    IWechatAuthService wechatAuthService;

	@ApiOperation("获取微信公众号accessToken")
  	@RequestMapping(value = "/getAccessToken", method = RequestMethod.GET)
  	public @ResponseBody Result getAccessToken(@ApiParam(value = "token", required = true) @ValidateParam({ Validator.NOT_BLANK }) String token) {
		LOG.info("获取微信公众号accessToken");
		WechatAssessTokenBo wechatAssessTokenBo = null;
		if(token.equals("ruzishici20170707")){
			wechatAssessTokenBo = wechatAuthService.getAssessToken();
		}
		return Result.createSuccessResult().setData(wechatAssessTokenBo);
  	}
	
	@ApiOperation("微信接入")
  	@RequestMapping(value = "/wechatAccessIn", method = RequestMethod.GET)
  	public @ResponseBody String wechatAccessIn(@ApiParam(value = "signature") String signature, @ApiParam(value = "timestamp") String timestamp, 
  					@ApiParam(value = "nonce") String nonce, @ApiParam(value = "echostr") String echostr) {
		LOG.info("微信接入");
		System.out.println(signature);
		System.out.println(timestamp);
		System.out.println(nonce);
		System.out.println(echostr);
		try {
			if (StringUtils.isNotBlank(echostr)) {
				System.out.println(new String(echostr.getBytes("ISO-8859-1"),"UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return echostr;
  	}
    
}
