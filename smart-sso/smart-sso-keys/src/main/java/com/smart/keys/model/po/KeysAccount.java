package com.smart.keys.model.po;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.smart.keys.model.param.KeysAccountParam;
import com.smart.mvc.config.ConfigUtils;
import com.smart.mvc.util.AESUtils;

public class KeysAccount {
    private Integer id;

    private String keyName;

    private String keyCode;

    private Integer keyStatus;

    private String userName;

    private String passWord;
    
    private Integer userId;

    private String keyDesc;

    private String loginAddress;

    private Integer sort;

    private Date createTime;

    private Date updateTime;
    
    //AES加密因子
	String encryptKey = ConfigUtils.getProperty("keys.encrypt.key");
    
    public KeysAccount() {}
    
    public KeysAccount(KeysAccountParam keysAccountParam) {
    	this.id = keysAccountParam.getId();
    	this.keyName = keysAccountParam.getKeyName();
    	this.userName = keysAccountParam.getUserName();
    	//密码加密
    	this.passWord = AESUtils.encrypt(encryptKey, keysAccountParam.getPassWord());
    	this.loginAddress = keysAccountParam.getLoginAddress();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode == null ? null : keyCode.trim();
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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : AESUtils.decrypt(encryptKey, passWord.trim());
    }

    public String getKeyDesc() {
        return keyDesc;
    }

    public void setKeyDesc(String keyDesc) {
        this.keyDesc = keyDesc == null ? null : keyDesc.trim();
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress == null ? null : loginAddress.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
    
}