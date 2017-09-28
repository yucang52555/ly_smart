package com.smart.position.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.controller.BaseController;
import com.smart.mvc.model.Pagination;
import com.smart.mvc.model.Result;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;
import com.smart.position.model.param.AccountUpdateParam;
import com.smart.position.model.po.Account;
import com.smart.position.service.IAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@Api(tags = "账号管理")
@Controller
@RequestMapping("/position/position")
public class PositionController extends BaseController {

	@Resource
	private IAccountService accountService;

	@ApiOperation("初始页")
	@RequestMapping(method = RequestMethod.GET)
	public String execute(Model model) {
		model.addAttribute("accountList", getAccountList());
		return "/account/account";
	}

	@ApiOperation("新增/修改页")
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@ApiParam(value = "id") Integer id, Model model) {
		Account account;
		if (id == null) {
			account = new Account();
		} else {
			account = accountService.get(id);
		}
		model.addAttribute("account", account);
		model.addAttribute("productList", getAccountList());
		return "/account/accountEdit";
	}

	@ApiOperation("列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Result list(
			@ApiParam(value = "产品名称") String keyName,
			@ApiParam(value = "开始页码", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize) {
		return Result.createSuccessResult().setData(accountService.findPaginationByAccount(keyName, new Pagination<Account>(pageNo, pageSize)));
	}

	@ApiOperation("新增/修改提交")
	@ApiResponse(response = Result.class, code = 200, message = "success")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Result save(AccountUpdateParam param) {
		Account account;
		if (param.getId() == null) {
			account = new Account();
			account.setCreateTime(new Date());
		} else {
			account = accountService.get(param.getId());
		}
		try {
			BeanUtils.copyProperties(account, param);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		accountService.save(account);
		return Result.createSuccessResult();
	}

	@ApiOperation("删除")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Result delete(
			@ApiParam(value = "ids", required = true) @ValidateParam({ Validator.NOT_BLANK }) String ids) {
		accountService.deleteById(getAjaxIds(ids));
		return Result.createSuccessResult();
	}

	private List<Account> getAccountList() {
		return accountService.findByAll(null);
	}
}