package com.smart.keys.model.param;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.swagger.annotations.ApiParam;

/**
 * 账号更新/新增参数模型
 * @author kangtiancheng
 * @date 2017年6月7日
 */
public class KeysAccountParam {
	
	/** id */
	private Integer id;
	/** 名称 */
	private String keyName;
	/** 编码  */
	private String keyCode;
	/** 状态  */
	private Integer keyStatus;
	/** 账号  */
	private String userName;
	/** 密码  */
	private String passWord;
	/** 排序 */
	private Integer sort = Integer.valueOf(1);
	/** 登录地址*/
	private String loginAddress;
	/** 描述 */
	private String keyDesc;
	
	private String wechatOpenId;
	/** 搜索关键词 */
	private String keyWord;
	
	@ApiParam(value = "id")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@ApiParam(value = "名称")
	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	@ApiParam(value = "编号")
	public String getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	
	@ApiParam(value = "状态")
	public Integer getKeyStatus() {
		return keyStatus;
	}

	public void setKeyStatus(Integer keyStatus) {
		this.keyStatus = keyStatus;
	}

	@ApiParam(value = "用户名")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@ApiParam(value = "密码")
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@ApiParam(value = "登录地址")
	public String getLoginAddress() {
		return loginAddress;
	}

	public void setLoginAddress(String loginAddress) {
		this.loginAddress = loginAddress;
	}

	@ApiParam(value = "描述")
	public String getKeyDesc() {
		return keyDesc;
	}

	public void setKeyDesc(String keyDesc) {
		this.keyDesc = keyDesc;
	}

	@ApiParam(value = "排序")
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	@ApiParam(value = "openid")
	public String getWechatOpenId() {
		return wechatOpenId;
	}

	public void setWechatOpenId(String wechatOpenId) {
		this.wechatOpenId = wechatOpenId;
	}
	
	@ApiParam(value = "关键词")
	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
