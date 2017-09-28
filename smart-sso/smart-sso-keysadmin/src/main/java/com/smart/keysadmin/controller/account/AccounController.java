package com.smart.keysadmin.controller.account;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.keysadmin.model.param.AccountUserParam;
import com.smart.keysadmin.model.param.AccountUserQueryParam;
import com.smart.keysadmin.model.po.AccountUser;
import com.smart.keysadmin.service.IAccountUserService;
import com.smart.mvc.controller.BaseController;
import com.smart.mvc.exception.BusinessException;
import com.smart.mvc.model.Result;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户账号管理
 * @author kangtiancheng
 * @date 2017年9月20日
 */
@Controller
@RequestMapping("/account/user")
public class AccounController extends BaseController {
	
	@Autowired
	IAccountUserService accountUserService;
	
	/**
     * 日志对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(AccounController.class);
    
    @ApiOperation("初始页")
	@RequestMapping(method = RequestMethod.GET)
	public String execute() {
		return "/admin/account";
	}
    
    @ApiOperation("查询用户列表")
  	@RequestMapping(value = "/list", method = RequestMethod.GET)
  	public @ResponseBody Result list(@ApiParam(value = "accountUserQueryParam", required = true) @ValidateParam({ Validator.NOT_BLANK }) AccountUserQueryParam accountUserQueryParam) {
		LOG.info("查询用户列表" + accountUserQueryParam.toString());
		List<AccountUser> data = null;
		try {
			data = accountUserService.list(accountUserQueryParam);
		} catch (BusinessException e) {
			return Result.createSuccessResult().setMessage(e.getMessage());
		}
		return Result.createSuccessResult().setData(data);
  	}
    
    @ApiOperation("删除用户列表")
  	@RequestMapping(value = "/delete", method = RequestMethod.POST)
  	public @ResponseBody Result delete(@ApiParam(value = "accountUserParam", required = true) @ValidateParam({ Validator.NOT_BLANK }) AccountUserParam accountUserParam) {
		LOG.info("删除用户列表" + accountUserParam.toString());
		Integer data = null;
		try {
			data = accountUserService.delete(accountUserParam.getAccountId());
		} catch (BusinessException e) {
			return Result.createSuccessResult().setMessage(e.getMessage());
		}
		return Result.createSuccessResult().setData(data);
  	}

}
