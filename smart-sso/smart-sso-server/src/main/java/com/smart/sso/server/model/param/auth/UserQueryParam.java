package com.smart.sso.server.model.param.auth;

import io.swagger.annotations.ApiParam;

/**
 * 用户查询参数
 * @author kangtiancheng
 * @date 2017年5月17日
 */
public class UserQueryParam {
	@ApiParam(value = "登录名")
	private String account;
	
	@ApiParam(value = "应用id") 
	private Integer appId;
	
	@ApiParam(value = "开始页码", required = true) 
	private Integer pageNo;
	
	@ApiParam(value = "显示条数", required = true) 
	private Integer pageSize;
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public Integer getAppId() {
		return appId;
	}
	
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
