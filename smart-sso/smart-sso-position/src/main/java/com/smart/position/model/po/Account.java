package com.smart.position.model.po;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.alibaba.fastjson.annotation.JSONField;
import com.smart.mvc.model.PersistentObject;

/**
 * 账号
 * @author kangtiancheng
 * @date 2017年6月6日
 */
public class Account extends PersistentObject {

	private static final long serialVersionUID = 6584402959131525219L;
	
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
	/** 创建时间 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/** 更新时间 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	/** 以下为显示辅助参数 */
	private Boolean isChecked = Boolean.valueOf(false);
	
	public Account(){
	}

	public Account(String keyName, String keyCode, Integer keyStatus, String userName, String passWord, 
			Integer sort, String loginAddress, String keyDesc, Date createTime, Date updateTime, Boolean isChecked) {
		this.keyName = keyName;
		this.keyCode = keyCode;
		this.keyStatus = keyStatus;
		this.userName = userName;
		this.passWord = passWord;
		this.sort = sort;
		this.loginAddress = loginAddress;
		this.keyDesc = keyDesc;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isChecked = isChecked;
	}

	public String getKeyName() {
		return keyName;
	}
	
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	
	public String getKeyCode() {
		return keyCode;
	}
	
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	
	public Integer getKeyStatus() {
		return keyStatus;
	}
	
	public void setKeyStatus(Integer keyStatus) {
		this.keyStatus = keyStatus;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getLoginAddress() {
		return loginAddress;
	}

	public void setLoginAddress(String loginAddress) {
		this.loginAddress = loginAddress;
	}

	public String getKeyDesc() {
		return keyDesc;
	}

	public void setKeyDesc(String keyDesc) {
		this.keyDesc = keyDesc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}
