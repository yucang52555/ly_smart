package com.smart.keys.controller.keys;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.keys.model.bo.wechat.WechatUserInfoBo;
import com.smart.keys.model.param.KeysAccountParam;
import com.smart.keys.model.param.WechatUserInfoParam;
import com.smart.keys.model.po.KeysAccount;
import com.smart.keys.service.keys.IKeysAccountService;
import com.smart.mvc.controller.BaseController;
import com.smart.mvc.exception.BusinessException;
import com.smart.mvc.model.Result;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "账号管理")
@Controller
@RequestMapping("/keys/account")
public class KeysAccountController extends BaseController {
	
	/**
     * 日志对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(KeysAccountController.class);
	
	@Resource
	private IKeysAccountService keysAccountService;
	
	@ApiOperation("根据openid查询账号列表")
  	@RequestMapping(value = "/selectKeysAccountByOpenid", method = RequestMethod.GET)
  	public @ResponseBody Result selectKeysAccountByOpenid(@ApiParam(value = "wechatUserInfo", required = true) @ValidateParam({ Validator.NOT_BLANK }) WechatUserInfoParam wechatUserInfo) {
		LOG.info("根据openid查询账号列表" + wechatUserInfo.toString());
		List<KeysAccount> data = null;
		try {
			WechatUserInfoBo userInfoBo = new WechatUserInfoBo(wechatUserInfo);
			data = keysAccountService.selectKeysAccountByOpenid(userInfoBo.getWechatOpenId());
		} catch (BusinessException e) {
			return Result.createSuccessResult().setMessage(e.getMessage());
		}
		return Result.createSuccessResult().setData(data);
  	}
	
	@ApiOperation("保存用户账号")
  	@RequestMapping(value = "/saveKeysAccount", method = RequestMethod.POST)
  	public @ResponseBody Result saveKeysAccount(@ValidateParam({ Validator.NOT_BLANK }) KeysAccountParam keysAccountParam) {
		LOG.info("根据openid查询账号列表" + keysAccountParam.toString());
		Integer data = null;
		try {
			KeysAccount keysAccount = new KeysAccount(keysAccountParam);
			data = keysAccountService.saveKeysAccount(keysAccount, keysAccountParam.getWechatOpenId());
		} catch (BusinessException e) {
			return Result.createSuccessResult().setMessage(e.getMessage());
		}
		return Result.createSuccessResult().setData(data);
  	}
	
	
	@ApiOperation("查询账号详情")
  	@RequestMapping(value = "/getKeysAccount", method = RequestMethod.GET)
  	public @ResponseBody Result getKeysAccount(@ValidateParam({ Validator.NOT_BLANK }) KeysAccountParam keysAccountParam) {
		LOG.info("查询账号详情" + keysAccountParam.toString());
		KeysAccount data = null;
		try {
			data = keysAccountService.getKeysAccount(keysAccountParam.getId());
		} catch (BusinessException e) {
			return Result.createSuccessResult().setMessage(e.getMessage());
		}
		return Result.createSuccessResult().setData(data);
  	}
	
	@ApiOperation("删除账号")
  	@RequestMapping(value = "/deleteKeysAccount", method = RequestMethod.POST)
  	public @ResponseBody Result deleteKeysAccount(@ValidateParam({ Validator.NOT_BLANK }) KeysAccountParam keysAccountParam) {
		LOG.info("删除账号" + keysAccountParam.toString());
		Integer data = null;
		try {
			data = keysAccountService.deleteKeysAccount(keysAccountParam.getId());
		} catch (BusinessException e) {
			return Result.createSuccessResult().setMessage(e.getMessage());
		}
		return Result.createSuccessResult().setData(data);
  	}
	
	@ApiOperation("查询根据关键词查询账号列表")
  	@RequestMapping(value = "/selectKeysAccountByUserKeyWord", method = RequestMethod.GET)
  	public @ResponseBody Result selectKeysAccountByUserKeyWord(@ValidateParam({ Validator.NOT_BLANK }) KeysAccountParam keysAccountParam) {
		LOG.info("查询根据关键词查询账号列表" + keysAccountParam.toString());
		List<KeysAccount> data = null;
		try {
			data = keysAccountService.selectKeysAccountByUserKeyWord(keysAccountParam.getWechatOpenId(), keysAccountParam.getKeyWord());
		} catch (BusinessException e) {
			return Result.createSuccessResult().setMessage(e.getMessage());
		}
		return Result.createSuccessResult().setData(data);
  	}
	

}